package ua.training.taxsystem.dto;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.taxsystem.persistence.entities.Report;
import ua.training.taxsystem.persistence.entities.ReportApproval;
import ua.training.taxsystem.persistence.entities.StateApproval;
import ua.training.taxsystem.persistence.entities.User;

import java.sql.Timestamp;

public class DtoMapper {
    private static DtoMapper instance;
    private static final Logger log = LogManager.getLogger(DtoMapper.class);

    private DtoMapper() {}

    public static DtoMapper getInstance() {
        if (instance == null) {
            instance = new DtoMapper();
        }
        return instance;
    }

    public ReportDetailsDto mapToReportDetailsDto(ReportApproval reportApproval) {
        Long reportApprovalId = reportApproval.getId();
        Report report = reportApproval.getReport();
        String refusalCause = reportApproval.getRefusalCause();
        Long approvalStateId = reportApproval.getStateApproval().getId();

        String inspectorName = null;
        String userName = null;
        Long inspectorId = null;
        Long userTypeId = null;

        final User inspector = reportApproval.getInspector();
        final User user = reportApproval.getUser();


        if(inspector != null && inspector.getFirstName() != null) {
            inspectorName = inspector.getFirstName() + " " + inspector.getLastName();
            inspectorId = inspector.getId();
        }

        if(user != null && user.getFirstName() != null) {
            userName = user.getFirstName() + " " + user.getLastName();
            userTypeId = user.getUserType().getId();
        }

        return new ReportDetailsDto.Builder()
                .reportApprovalId(reportApprovalId)
                .report(report)
                .refusalCause(refusalCause)
                .approvalStateId(approvalStateId)
                .inspectorName(inspectorName)
                .inspectorId(inspectorId)
                .userTypeId(userTypeId)
                .userName(userName)
                .build();
    }

    public SentReportsDto mapToSentReportsDto(ReportApproval reportApproval) {
        final StateApproval stateApproval = reportApproval.getStateApproval();
        final long reportId = reportApproval.getReport().getId();
        final long reportApprovalId = reportApproval.getId();
        final String state = stateApproval.getState();
        final Timestamp timestamp = reportApproval.getTimestamp();
        final User inspector = reportApproval.getInspector();
        final User user = reportApproval.getUser();
        final String inspectorName = (inspector != null && inspector.getFirstName() != null) ? inspector.getFirstName() + " " + inspector.getLastName() : "";
        final String userName = (user.getFirstName() != null) ? user.getFirstName() + " " + user.getLastName() : "";
        return new SentReportsDto(reportId, state, inspectorName, userName, timestamp, reportApprovalId);
    }

    public ReportDto mapToReportDto(Report report) {
        final long reportId = report.getId();
        final double sum = report.getSum();
        final int quarter = report.getQuarter();
        final long taxTypeId = report.getTaxType().getId();

        return new ReportDto(reportId, taxTypeId, quarter, sum);
    }
}
