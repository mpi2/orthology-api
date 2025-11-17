#!/bin/bash
set -e

DEBUG=false

ENDPOINT='http://hh-rke-wp-webadmin-20-worker-1.caas.ebi.ac.uk:31016/api/ortholog'


for i in "$@"
do
case $i in
    -d-hh|--hh-dev)
   ENDPOINT='http://hh-rke-wp-webadmin-20-worker-1.caas.ebi.ac.uk:31016/api/ortholog'
    shift # past argument
    ;;
    -d-hx|--hx-dev)
    ENDPOINT='http://hx-rke-wp-webadmin-20-worker-1.caas.ebi.ac.uk:31016/api/ortholog'
    shift # past argument
    ;;
    -p-hh|--hh-production)
    ENDPOINT='http://hh-rke-wp-webadmin-20-worker-1.caas.ebi.ac.uk:31037/api/ortholog'
    shift # past argument
    ;;
    -p-hx|--hx-production)
    ENDPOINT='http://hx-rke-wp-webadmin-20-worker-1.caas.ebi.ac.uk:31037/api/ortholog'
    shift # past argument
    ;;
    -p-re|--reference)
    ENDPOINT='https://www.gentar.org/orthology-api/api/ortholog'
    shift # past argument
    ;;
    --default)
      error_exit "default error exit";
    shift # past argument
    ;;
    *)
      error_exit "Unknowing error exit";
          # unknown option
    ;;
esac
done



error_exit()
{
    printf '%s\n' "$1" 1>&2;
    exit 1;
}
check_http_status_code()
{
    json_response_with_status="$1"

    status=${json_response_with_status:${#json_response_with_status}<3?0:-3}

    if [ "$status" != "200" ]; then
          error_exit "A $status= response was received from the server.";
    fi;
}


process_query()
{

    if [ "$#" -ne 3 ]; then
        error_exit "Usage: process_query service_endpoint query expected_output";
    fi;

    expected="$1"
    unfix="$2$3"


    if [ "$DEBUG" = true ]; then
        echo "curl -sSLN -w "%{http_code}"  \"${ENDPOINT}$unfix\" --tls-max 1.2 --tlsv1.2  --ciphers DEFAULT@SECLEVEL=1 -H \"Content-type: application/json\" -H \"cache-control: no-cache\""
    fi

    data=$(curl -sSLN -w "%{http_code}" "${ENDPOINT}$unfix" --tls-max 1.2 --tlsv1.2  --ciphers DEFAULT@SECLEVEL=1 -H "Content-type: application/json" -H "cache-control: no-cache")
    check_http_status_code "$data"

    # Remove the 200 status code from the end of the response and process
    json=${data%200}
    if [ "$json" != "$expected" ]; then
    	echo "** Failed **"
        error_exit "The result: $json does not match the expected_output $expected";
    else
    	echo "Passed"
    fi
    
    printf '\n'

}

run_test()
{
    if [ "$#" -ne 3 ]; then
        error_exit "Usage: run_test query expected_output";
    fi;
    process_query "$1" "$2" "$3"
}


find_one_to_one_by_mouse_genes_test()
{

    parameter="?genes=A1bg"
    endpoint="/one_to_one/find_by_mouse_genes"
    expected_result='[{"humanGeneSymbol":"A1BG","hgncAccId":"HGNC:5","humanSupportCountThreshold":5,"humanCategoryForThreshold":"one-to-one","humanOrthologsAboveThreshold":1,"category":"GOOD","supportCount":12,"isMaxHumanToMouse":"max","isMaxMouseToHuman":"max","mouseOrthologsAboveThreshold":1,"mouseCategoryForThreshold":"one-to-one","mouseSupportCountThreshold":5,"mgiGeneAccId":"MGI:2152878","mouseGeneSymbol":"A1bg"}]'

    echo "Find by mouse genes test for: ${ENDPOINT}$endpoint$parameter"
    run_test  "$expected_result" "$endpoint" "$parameter"

}

find_one_to_one_by_human_genes_test()
{


    parameter="?genes=CIB2"
    endpoint="/one_to_one/find_by_human_genes"
    expected_result='[{"humanGeneSymbol":"CIB2","hgncAccId":"HGNC:24579","humanSupportCountThreshold":5,"humanCategoryForThreshold":"one-to-one","humanOrthologsAboveThreshold":1,"category":"GOOD","supportCount":11,"isMaxHumanToMouse":"max","isMaxMouseToHuman":"max","mouseOrthologsAboveThreshold":1,"mouseCategoryForThreshold":"one-to-one","mouseSupportCountThreshold":5,"mgiGeneAccId":"MGI:1929293","mouseGeneSymbol":"Cib2"}]'
    echo "Find by human genes test for: ${ENDPOINT}$endpoint$parameter"
    run_test  "$expected_result" "$endpoint" "$parameter"

}

find_one_to_one_by_mgi_ids_test()
{


    parameter="?mgiIds=MGI:1917115"
    endpoint="/one_to_one/find_by_mgi_ids"
    expected_result='[{"humanGeneSymbol":"A1CF","hgncAccId":"HGNC:24086","humanSupportCountThreshold":5,"humanCategoryForThreshold":"one-to-one","humanOrthologsAboveThreshold":1,"category":"GOOD","supportCount":10,"isMaxHumanToMouse":"max","isMaxMouseToHuman":"max","mouseOrthologsAboveThreshold":1,"mouseCategoryForThreshold":"one-to-one","mouseSupportCountThreshold":5,"mgiGeneAccId":"MGI:1917115","mouseGeneSymbol":"A1cf"}]'
    echo "Find one_to_one_ by mouse gene ids test for: ${ENDPOINT}$endpoint$parameter"
    run_test  "$expected_result" "$endpoint" "$parameter"

}

find_one_to_one_by_hgnc_ids_genes_test()
{
    parameter="?hgncIds=HGNC:24086"
    endpoint="/one_to_one/find_by_hgnc_ids"
    expected_result='[{"humanGeneSymbol":"A1CF","hgncAccId":"HGNC:24086","humanSupportCountThreshold":5,"humanCategoryForThreshold":"one-to-one","humanOrthologsAboveThreshold":1,"category":"GOOD","supportCount":10,"isMaxHumanToMouse":"max","isMaxMouseToHuman":"max","mouseOrthologsAboveThreshold":1,"mouseCategoryForThreshold":"one-to-one","mouseSupportCountThreshold":5,"mgiGeneAccId":"MGI:1917115","mouseGeneSymbol":"A1cf"}]'
    echo "Find by human gene ids test for: ${ENDPOINT}$endpoint$parameter"
    run_test  "$expected_result" "$endpoint" "$parameter"

}

find_all_by_mgi_ids_test()
{
    parameter="?mgiIds=MGI:1917115"
    endpoint="/find_all_by_mgi_ids"
    expected_result='[{"humanGeneSymbol":"A1CF","hgncAccId":"HGNC:24086","humanSupportCountThreshold":5,"humanCategoryForThreshold":"one-to-one","humanOrthologsAboveThreshold":1,"category":"GOOD","supportCount":10,"isMaxHumanToMouse":"max","isMaxMouseToHuman":"max","mouseOrthologsAboveThreshold":1,"mouseCategoryForThreshold":"one-to-one","mouseSupportCountThreshold":5,"mgiGeneAccId":"MGI:1917115","mouseGeneSymbol":"A1cf"}]'
    echo "Find all by mouse gene ids test for: ${ENDPOINT}$endpoint$parameter"
    run_test  "$expected_result" "$endpoint" "$parameter"

}

main()
{
    find_one_to_one_by_mouse_genes_test
    find_one_to_one_by_human_genes_test
    find_one_to_one_by_mgi_ids_test
    find_one_to_one_by_hgnc_ids_genes_test
    find_all_by_mgi_ids_test
}

main