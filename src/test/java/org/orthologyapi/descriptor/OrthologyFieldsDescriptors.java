package org.orthologyapi.descriptor;

import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;

import java.util.ArrayList;
import java.util.List;
import org.springframework.restdocs.payload.FieldDescriptor;

public class OrthologyFieldsDescriptors {

    public static List<FieldDescriptor> getOrthologyFieldsDescriptions(String prefix) {
        List<FieldDescriptor> orthologyFieldsDescriptions = new ArrayList<>();
        addField(orthologyFieldsDescriptions, prefix + "[].humanGeneSymbol", "Human Gene Symbol");
        addField(orthologyFieldsDescriptions, prefix + "[].hgncAccId", "Human Gene Accession Id");
        addField(orthologyFieldsDescriptions, prefix + "[].humanSupportCountThreshold", "Human Support Count Threshold");
        addField(orthologyFieldsDescriptions, prefix + "[].humanCategoryForThreshold", "Human Category For Threshold");
        addField(orthologyFieldsDescriptions, prefix + "[].humanOrthologsAboveThreshold", "Human Orthologs Above Threshold");
        addField(orthologyFieldsDescriptions, prefix + "[].category", "Category");
        addField(orthologyFieldsDescriptions, prefix + "[].supportCount", "Support Count");
        addField(orthologyFieldsDescriptions, prefix + "[].isMaxHumanToMouse", "Is Max Human To Mouse");
        addField(orthologyFieldsDescriptions, prefix + "[].isMaxMouseToHuman", "Is Max Mouse To Human");
        addField(orthologyFieldsDescriptions, prefix + "[].mouseOrthologsAboveThreshold", "Mouse Orthologs Above Threshold");
        addField(orthologyFieldsDescriptions, prefix + "[].mouseCategoryForThreshold", "Mouse Category For Threshold");
        addField(orthologyFieldsDescriptions, prefix + "[].mouseSupportCountThreshold", "Mouse Support Count Threshold");
        addField(orthologyFieldsDescriptions, prefix + "[].mgiGeneAccId", "Mouse Gene Accession Id");
        addField(orthologyFieldsDescriptions, prefix + "[].mouseGeneSymbol", "Mouse Gene Symbol");
        if (prefix.equals("_embedded.orthologDtoList.")) {
            addField(orthologyFieldsDescriptions, "_links.self.href", "Self Link");
            addField(orthologyFieldsDescriptions, "page.size", "Page Size");
            addField(orthologyFieldsDescriptions, "page.totalElements", "Total Elements");
            addField(orthologyFieldsDescriptions, "page.totalPages", "Total Pages");
            addField(orthologyFieldsDescriptions, "page.number", "Page Number");

        }
        return orthologyFieldsDescriptions;
    }


    private static void addField(List<FieldDescriptor> list, String name, String description) {
        list.add(fieldWithPath(name).description(description).optional());
    }
}
