package org.orthologyapi.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.orthologyapi.descriptor.OrthologMapper;
import org.orthologyapi.dto.OrthologDto;
import org.orthologyapi.repository.OrthologRepository;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

    OrthologRepository orthologRepository;

    public ReportService(OrthologRepository orthologRepository) {
        this.orthologRepository = orthologRepository;
    }

    public boolean writeReportForAllOthologs(HttpServletResponse response) throws IOException {
        List<OrthologDto> orthologDtos =
            orthologRepository.findAllOrthologsForTsvFile().stream().map(
                OrthologMapper::orthologToDto).toList();
        printReport(response, orthologDtos);
        return true;
    }

    public boolean writeReportForOneToOneImpcOrthologs(HttpServletResponse response) throws IOException {
        List<OrthologDto> orthologDtos =
            orthologRepository.findOneToOneImpcOrthologsForTsvFile().stream().map(
                OrthologMapper::orthologToDto).toList();
        printReport(response, orthologDtos);
        return true;
    }


    private void printReport(HttpServletResponse response,
                             List<OrthologDto> orthologDtos) throws IOException {

        PrintWriter output = response.getWriter();

        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");
        response.setHeader("Content-disposition", "attachment; filename=One To one orthologs " +
            LocalDate.now() + ".tsv");

        output.println(convertListToTsvFileFormat(orthologDtos));
        output.flush();
        output.close();
    }

    private List<String> convertListToString(List<OrthologDto> orthologDtos) {
        List<String> orthologDtoStringList = new ArrayList<>();

        for (OrthologDto orthologDto : orthologDtos) {
            orthologDtoStringList.add(mapOrthologToString(orthologDto));
        }

        return orthologDtoStringList;
    }

    private String convertListToTsvFileFormat(List<OrthologDto> orthologDtos) {
        String header = generateReportHeaders();

        String report = String.join("\n", convertListToString(orthologDtos));

        return String.join("\n", header, report);
    }

    private String generateReportHeaders() {
        List<String> headers = Arrays.asList(
            "Human Gene Symbol",
            "Hgnc Acc Id",
            "Human Support Count Threshold",
            "Human Category For Threshold",
            "Human Orthologs Above Threshold",
            "Category",
            "Support Count",
            "Is Max Human To Mouse",
            "Is Max Mouse To Human",
            "Mouse Orthologs AboveT hreshold",
            "Mouse Category For Threshold",
            "Mouse Support Count Threshold",
            "Mgi Gene Acc Id",
            "Mouse Gene Symbol"

        );

        return String.join("\t", headers);

    }

    private String mapOrthologToString(OrthologDto orthologDto) {
        String orthologDtoString = "";
        orthologDtoString += orthologDto.getHumanGeneSymbol() + "\t";
        orthologDtoString += orthologDto.getHgncAccId() + "\t";
        orthologDtoString += orthologDto.getHumanSupportCountThreshold() + "\t";
        orthologDtoString += orthologDto.getHumanCategoryForThreshold() + "\t";
        orthologDtoString += orthologDto.getHumanOrthologsAboveThreshold() + "\t";
        orthologDtoString += orthologDto.getCategory() + "\t";
        orthologDtoString += orthologDto.getSupportCount() + "\t";
        orthologDtoString += orthologDto.getIsMaxHumanToMouse() + "\t";
        orthologDtoString += orthologDto.getIsMaxMouseToHuman() + "\t";
        orthologDtoString += orthologDto.getMouseOrthologsAboveThreshold() + "\t";
        orthologDtoString += orthologDto.getMouseCategoryForThreshold() + "\t";
        orthologDtoString += orthologDto.getMouseSupportCountThreshold() + "\t";
        orthologDtoString += orthologDto.getMgiGeneAccId() + "\t";
        orthologDtoString += orthologDto.getMouseGeneSymbol() + "\t";

        return orthologDtoString;
    }


}
