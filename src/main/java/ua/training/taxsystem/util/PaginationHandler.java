package ua.training.taxsystem.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.taxsystem.dto.PaginationDto;

public class PaginationHandler {
    private int pageSize;
//    private long offSet = 0;
    private int startVisibleIndex;
    private int endVisibleIndex;
    private int currentPageIndex;

//    private int allRowsAmount;
    private int allPagesAmount;

    private static final int DEFAULT_PAGE_SIZE = 3; // 5
    private static final int DEFAULT_START_INDEX = 0;
    private static final int DEFAULT_END_INDEX = 4;

    private boolean isLeftButtonDisabled;
    private boolean isRightButtonDisabled;
    private PaginationDto paginationDto;

    public void setPaginationDto(PaginationDto paginationDto) {
        if (paginationDto != null) {
            this.paginationDto = paginationDto;
        } else {
            this.startVisibleIndex = DEFAULT_START_INDEX;
            this.endVisibleIndex = DEFAULT_END_INDEX;
            this.currentPageIndex = DEFAULT_START_INDEX;
            this.pageSize = DEFAULT_PAGE_SIZE;
        }
    }

    public PaginationDto getPaginationDto() {
        return paginationDto;
    }

    private static final Logger log = LogManager.getLogger(PaginationHandler.class);

    public void handlePagination() {
        if (paginationDto != null) {
            this.startVisibleIndex = paginationDto.getStartPageIndex();
            this.endVisibleIndex = paginationDto.getEndPageIndex();
            this.currentPageIndex = paginationDto.getCurrentPageIndex();
            String pageSize = paginationDto.getPageSize();
            this.pageSize = (pageSize != null) ? Integer.valueOf(pageSize) : DEFAULT_PAGE_SIZE;
        }

//        calculateAllPagesAmount();
        calculateEndVisibleIndex();
        changeButtonsState();

        if(paginationDto.getNextClicked()) {
            handleNextButtonClick();
        } else if (paginationDto.getPreviousClicked()) {
            handlePreviousButtonClick();
        } else {
            log.info("calculateOffset");
//            calculateOffset();
        }
    }

    public void updatePaginationInfo() {
        paginationDto.setCurrentPageIndex(currentPageIndex);
        paginationDto.setStartPageIndex(startVisibleIndex);
        paginationDto.setEndPageIndex(endVisibleIndex);
        paginationDto.setLeftButtonDisabled(isLeftButtonDisabled);
        paginationDto.setRightButtonDisabled(isRightButtonDisabled);
        paginationDto.setAllPagesAmount(allPagesAmount);
        paginationDto.setPageSize(String.valueOf(pageSize));
    }

//    public void setAllRowsAmount(int allRowsAmount) {
//        this.allRowsAmount = allRowsAmount;
//    }

//
//    public void calculateAllPagesAmount() {
//        allPagesAmount = allRowsAmount / this.pageSize;
//        allPagesAmount += allPagesAmount % this.pageSize > 0 ? 1 : 0;
//    }

    public void calculateEndVisibleIndex() {
        log.info("endVisibleIndex before - {}", endVisibleIndex);
        if (allPagesAmount == 0) {
            endVisibleIndex = 0;
        } else if(endVisibleIndex == 0 & allPagesAmount > DEFAULT_END_INDEX) {
            endVisibleIndex = DEFAULT_END_INDEX;
        } else if(allPagesAmount < DEFAULT_END_INDEX) {
            endVisibleIndex = allPagesAmount-1;
        }
        log.info("endVisibleIndex after - {}", endVisibleIndex);

    }

    // 3
//    public void calculateOffset() { // 2
//        offSet = currentPageIndex * pageSize;
//    }

    public void handleNextButtonClick() {
        if(currentPageIndex < endVisibleIndex) {
            currentPageIndex += 1;
        } else if(currentPageIndex == endVisibleIndex) {
            shiftPagesIndexes(true);
        }
        changeButtonsState();
//        calculateOffset();
    }

    public void handlePreviousButtonClick() {
        if(currentPageIndex > startVisibleIndex) {
            currentPageIndex-=1;
        } else if(currentPageIndex == startVisibleIndex) {
                shiftPagesIndexes(false);
        }
        changeButtonsState();
//        calculateOffset();
    }

    public void changeButtonsState() {
        isLeftButtonDisabled = (currentPageIndex == startVisibleIndex) & (currentPageIndex == DEFAULT_START_INDEX);
        isRightButtonDisabled = currentPageIndex == allPagesAmount-1;
    }

    private void shiftPagesIndexes(boolean forward) {
        startVisibleIndex += forward ? 1 : -1;
        endVisibleIndex += forward ? 1 : -1;
        currentPageIndex += forward ? 1 : -1;

        log.info("shift indexes");
        log.info("startVisibleIndex - {}", startVisibleIndex);
        log.info("endVisibleIndex - {}", endVisibleIndex);
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getCurrentPageIndex() {
        return currentPageIndex;
    }

    public void setAllPagesAmount(int allPagesAmount) {
        this.allPagesAmount = allPagesAmount;
    }
}
