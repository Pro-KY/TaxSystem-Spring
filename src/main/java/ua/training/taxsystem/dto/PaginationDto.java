package ua.training.taxsystem.dto;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.taxsystem.util.constans.Parameters;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.List;

public class PaginationDto implements Serializable {
    private static final Logger log = LogManager.getLogger(PaginationDto.class);

    private Integer currentPageIndex;
    private Boolean isNextClicked;
    private Boolean isPreviousClicked;
    private String pageSize;
    private Long userId;
    private static final int DEFAULT_START_INDEX = 0;
    private boolean isLeftButtonDisabled;
    private boolean isRightButtonDisabled;
    private Integer startPageIndex;
    private Integer endPageIndex;
    private int allPagesAmount;

    private List paginationList;

    public void setPaginationRequestContent(HttpServletRequest request) {
        String selectedPageIndex = request.getParameter(Parameters.SELECTED_PAGE_INDEX);
        final String pageSize = request.getParameter(Parameters.PAGE_SIZE);
        final String isNextClicked = request.getParameter(Parameters.NEXT_PAGE_CLICK);
        final String isPreviousClicked = request.getParameter(Parameters.PREV_PAGE_CLICK);

        if (selectedPageIndex == null && currentPageIndex != null) {
            selectedPageIndex = currentPageIndex.toString();
        }

        this.currentPageIndex = (selectedPageIndex != null) ? Integer.valueOf(selectedPageIndex) : DEFAULT_START_INDEX;
        this.isNextClicked = (isNextClicked != null) ? Boolean.valueOf(isNextClicked) : false;
        this.isPreviousClicked = (isPreviousClicked != null) ? Boolean.valueOf(isPreviousClicked) : false;
        this.pageSize = pageSize;
    }

    public List getPaginationList() {
        return paginationList;
    }

    public void setPaginationList(List paginationList) {
        this.paginationList = paginationList;
    }

    public PaginationDto() {
        currentPageIndex = DEFAULT_START_INDEX;
        this.isNextClicked =  false;
        this.isPreviousClicked = false;
    }

    public Integer getCurrentPageIndex() {
        return currentPageIndex;
    }

    public void setCurrentPageIndex(Integer currentPageIndex) {
        this.currentPageIndex = currentPageIndex;
    }

    public Boolean getNextClicked() {
        return isNextClicked;
    }

    public void setNextClicked(Boolean nextClicked) {
        isNextClicked = nextClicked;
    }

    public Boolean getPreviousClicked() {
        return isPreviousClicked;
    }

    public void setPreviousClicked(Boolean previousClicked) {
        isPreviousClicked = previousClicked;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public static int getDefaultStartIndex() {
        return DEFAULT_START_INDEX;
    }

    public boolean isLeftButtonDisabled() {
        return isLeftButtonDisabled;
    }

    public void setLeftButtonDisabled(boolean leftButtonDisabled) {
        isLeftButtonDisabled = leftButtonDisabled;
    }

    public boolean isRightButtonDisabled() {
        return isRightButtonDisabled;
    }

    public void setRightButtonDisabled(boolean rightButtonDisabled) {
        isRightButtonDisabled = rightButtonDisabled;
    }

    public Integer getStartPageIndex() {
        return startPageIndex;
    }

    public void setStartPageIndex(Integer startPageIndex) {
        this.startPageIndex = startPageIndex;
    }

    public Integer getEndPageIndex() {
        return endPageIndex;
    }

    public void setEndPageIndex(Integer endPageIndex) {
        this.endPageIndex = endPageIndex;
    }

    public int getAllPagesAmount() {
        return allPagesAmount;
    }

    public void setAllPagesAmount(int allPagesAmount) {
        this.allPagesAmount = allPagesAmount;
    }

    @Override
    public String toString() {
        return "PaginationDto{" +
                "isLeftButtonDisabled=" + isLeftButtonDisabled +
                ", isRightButtonDisabled=" + isRightButtonDisabled +
                ", startPageIndex=" + startPageIndex +
                ", endPageIndex=" + endPageIndex +
                ", currentPageIndex=" + currentPageIndex +
                ", isNextClicked=" + isNextClicked +
                ", isPreviousClicked=" + isPreviousClicked +
                ", allPagesAmount=" + allPagesAmount +
                ", pageSize=" + pageSize +
                ", paginationListSize=" + (paginationList != null ? paginationList.size() : "empty") +
                '}';
    }
}
