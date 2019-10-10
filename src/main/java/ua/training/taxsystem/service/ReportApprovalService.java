package ua.training.taxsystem.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ua.training.taxsystem.dto.DtoMapper;
import ua.training.taxsystem.dto.PaginationDto;
import ua.training.taxsystem.dto.SentReportsDto;
import ua.training.taxsystem.persistence.entities.ReportApproval;
import ua.training.taxsystem.persistence.entities.StateApproval;
import ua.training.taxsystem.persistence.entities.User;
import ua.training.taxsystem.persistence.repositories.ReportApprovalRepository;
import ua.training.taxsystem.util.PaginationHandler;
import ua.training.taxsystem.util.constans.StateApprovalEnum;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
@AllArgsConstructor
public class ReportApprovalService {
    private final ReportApprovalRepository repository;

    public PaginationDto getUntreatedReports(PaginationDto paginationDto, StateApproval stateApproval, User inspector) {

        boolean isStateApprovalProcessing = stateApproval.getId().equals(StateApprovalEnum.PROCESSING.getStateId());
        final PaginationHandler paginationHandler = paginationHandler();
        paginationHandler.setPaginationDto(paginationDto);

        Pageable pageable = PageRequest.of(paginationHandler.getCurrentPageIndex(), paginationHandler.getPageSize(), Sort.by("id").ascending());

        Page<ReportApproval> page;

        if(isStateApprovalProcessing) {
            page = repository.findAllByStateApproval(stateApproval, pageable);
        } else {
            page = repository.findAllByStateApprovalAndInspector(stateApproval, inspector, pageable);
        }

        final int totalPages = page.getTotalPages();

        paginationHandler.setAllPagesAmount(totalPages);
        paginationHandler.handlePagination();

        final List<ReportApproval> content = page.getContent();

        final List<SentReportsDto> collect = content.stream()
                .map(reportApproval -> DtoMapper.getInstance().mapToSentReportsDto(reportApproval))
                .collect(Collectors.toList());

        paginationDto.setPaginationList(collect);
        paginationHandler.updatePaginationInfo();
        return paginationHandler.getPaginationDto();
    }

    @Lookup
    private PaginationHandler paginationHandler() {
        log.info("paginationHandler called");
        return null;
    }
}
