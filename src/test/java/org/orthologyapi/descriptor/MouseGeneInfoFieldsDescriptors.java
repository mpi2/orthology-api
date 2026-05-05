package org.orthologyapi.descriptor;

import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;

import java.util.ArrayList;
import java.util.List;
import org.springframework.restdocs.payload.FieldDescriptor;

public class MouseGeneInfoFieldsDescriptors {

    public static List<FieldDescriptor> getMouseGeneInfoFieldsDescriptions() {
        List<FieldDescriptor> fields = new ArrayList<>();
        addField(fields, "[].ensemblChromosome", "Ensembl Chromosome");
        addField(fields, "[].ensemblGeneAccId", "Ensembl Gene Accession Id");
        addField(fields, "[].ensemblStart", "Ensembl Start");
        addField(fields, "[].ensemblStop", "Ensembl Stop");
        addField(fields, "[].ensemblStrand", "Ensembl Strand");
        addField(fields, "[].mgiGeneAccId", "Mouse Gene Accession Id");
        addField(fields, "[].symbol", "Mouse Gene Symbol");
        return fields;
    }

    private static void addField(List<FieldDescriptor> list, String name, String description) {
        list.add(fieldWithPath(name).description(description).optional());
    }
}
