package org.orthologyapi.projection;

import org.springframework.beans.factory.annotation.Value;

public interface OrthologProjection {

    @Value("#{target.humanGeneSymbol}")
    String getHumanGeneSymbol();

    @Value("#{target.hgncAccId}")
    String getHgncAccId();

    @Value("#{target.humanSupportCountThreshold}")
    Long getHumanSupportCountThreshold();

    @Value("#{target.humanCategoryForThreshold}")
    String getHumanCategoryForThreshold();

    @Value("#{target.humanOrthologsAboveThreshold}")
    Long getHumanOrthologsAboveThreshold();

    @Value("#{target.category}")
    String getCategory();

    @Value("#{target.supportCount}")
    Long getSupportCount();

    @Value("#{target.isMaxHumanToMouse}")
    String getIsMaxHumanToMouse();

    @Value("#{target.isMaxMouseToHuman}")
    String getIsMaxMouseToHuman();

    @Value("#{target.mouseOrthologsAboveThreshold}")
    Long getMouseOrthologsAboveThreshold();

    @Value("#{target.mouseCategoryForThreshold}")
    String getMouseCategoryForThreshold();

    @Value("#{target.mouseSupportCountThreshold}")
    Long getMouseSupportCountThreshold();

    @Value("#{target.mgiGeneAccId}")
    String getMgiGeneAccId();

    @Value("#{target.mouseGeneSymbol}")
    String getMouseGeneSymbol();
}
