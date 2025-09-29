package org.orthologyapi.service;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.orthologyapi.descriptor.OrthologMapper;
import org.orthologyapi.dto.OrthologDto;
import org.orthologyapi.repository.OrthologRepository;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

    private final OrthologRepository orthologRepository;

    public ReportService(OrthologRepository orthologRepository) {
        this.orthologRepository = orthologRepository;
    }

    public boolean writeReportForAllOthologs(HttpServletResponse response) throws IOException {
        List<OrthologDto> orthologDtos =
                orthologRepository.findAllOrthologsForTsvFile().stream().map(
                        OrthologMapper::orthologToDto).toList();
        printReport(response, orthologDtos, "Orthologs");
        return true;
    }


    public boolean writeReportForOneToOneAllOrthologs(HttpServletResponse response) throws IOException {
        List<OrthologDto> orthologDtos =
                orthologRepository.findOneToOneAllOrthologsForTsvFile().stream().map(
                        OrthologMapper::orthologToDto).toList();
        printReport(response, orthologDtos, "One To one orthologs");
        return true;
    }

    public boolean writeReportForOneToOneImpcOrthologs(HttpServletResponse response) throws IOException {
        List<OrthologDto> orthologDtos =
                orthologRepository.findOneToOneImpcOrthologsForTsvFile().stream().map(
                        OrthologMapper::orthologToDto).toList();
        printReport(response, orthologDtos, "One To one orthologs");
        return true;
    }


    private void printReport(HttpServletResponse response,
                             List<OrthologDto> orthologDtos,
                             String filename) throws IOException {

        PrintWriter output = response.getWriter();

        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");
        response.setHeader("Content-disposition", "attachment; filename= " + filename +
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
        orthologDtoString += orthologDto.humanGeneSymbol() + "\t";
        orthologDtoString += orthologDto.hgncAccId() + "\t";
        orthologDtoString += orthologDto.humanSupportCountThreshold() + "\t";
        orthologDtoString += orthologDto.humanCategoryForThreshold() + "\t";
        orthologDtoString += orthologDto.humanOrthologsAboveThreshold() + "\t";
        orthologDtoString += orthologDto.category() + "\t";
        orthologDtoString += orthologDto.supportCount() + "\t";
        orthologDtoString += orthologDto.isMaxHumanToMouse() + "\t";
        orthologDtoString += orthologDto.isMaxMouseToHuman() + "\t";
        orthologDtoString += orthologDto.mouseOrthologsAboveThreshold() + "\t";
        orthologDtoString += orthologDto.mouseCategoryForThreshold() + "\t";
        orthologDtoString += orthologDto.mouseSupportCountThreshold() + "\t";
        orthologDtoString += orthologDto.mgiGeneAccId() + "\t";
        orthologDtoString += orthologDto.mouseGeneSymbol() + "\t";

        return orthologDtoString;
    }


}
