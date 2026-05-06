package org.orthologyapi.descriptor;

import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;

import java.util.ArrayList;
import java.util.List;
import org.springframework.restdocs.payload.FieldDescriptor;

public class MouseGeneFullFieldsDescriptors {

    public static List<FieldDescriptor> getMouseGeneFullFieldsDescriptions() {
        List<FieldDescriptor> fields = new ArrayList<>();
        addField(fields, "[].ensemblChromosome", "Ensembl Chromosome");
        addField(fields, "[].ensemblGeneAccId", "Ensembl Gene Accession Id");
        addField(fields, "[].ensemblStart", "Ensembl Start");
        addField(fields, "[].ensemblStop", "Ensembl Stop");
        addField(fields, "[].ensemblStrand", "Ensembl Strand");
        addField(fields, "[].entrezGeneAccId", "Entrez Gene Accession Id");
        addField(fields, "[].genomeBuild", "Genome Build");
        addField(fields, "[].mgiChromosome", "MGI Chromosome");
        addField(fields, "[].mgiCm", "MGI cM Position");
        addField(fields, "[].mgiGeneAccId", "MGI Gene Accession Id");
        addField(fields, "[].mgiStart", "MGI Start");
        addField(fields, "[].mgiStop", "MGI Stop");
        addField(fields, "[].mgiStrand", "MGI Strand");
        addField(fields, "[].name", "Mouse Gene Name");
        addField(fields, "[].ncbiChromosome", "NCBI Chromosome");
        addField(fields, "[].ncbiStart", "NCBI Start");
        addField(fields, "[].ncbiStop", "NCBI Stop");
        addField(fields, "[].ncbiStrand", "NCBI Strand");
        addField(fields, "[].subtype", "Mouse Gene Subtype");
        addField(fields, "[].symbol", "Mouse Gene Symbol");
        addField(fields, "[].type", "Mouse Gene Type");
        return fields;
    }

    private static void addField(List<FieldDescriptor> list, String name, String description) {
        list.add(fieldWithPath(name).description(description).optional());
    }
}
