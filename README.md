# orthology-api
API service for the orthology database
#### Usage of HTTP Verbs
The following table describes how the Orthology API interprets the HTTP verbs.

.HTTP Verbs

| HTTP Verb | Usage
| ------ | ------ |
|GET|GET is used to retrieve information without changing the state of the system.

Other verbs, such as DELETE, POST, UPDATE are not supported by Ortgology at present.
#### Pagination and Sorting
Most of the endpoints returning collections are paginated and can be sorted. If no parameters are
specified, then the default ones are applied.
##### Pagination
The parameters to specify the pagination are:

|Parameter | Description
| ------ | ------ |
|page|Number of the page to retrieve. It starts with 0 (which is the default value).
|size|Number of elements to retrieve.
#### ONE TO ONE ORTHOLOGS
This section describes the REST endpoints for one oto one in the system.

Orthology api provides GET endpoints that provides the one to one orthologs data for the essential genes and the reference database services
##### Fields
These are the fields you are going to see in the body of a request in a GET or in the payload for POST or PUT
operations.

Path|	Type|	Description
| ------ | ------ | ------ |
|humanGeneSymbol|String|Human Gene Symbol
|hgncAccId|String|Human Gene Accession Id
|humanSupportCountThreshold|Number|Human Support Count Threshold
|humanCategoryForThreshold|String|Human Category For Threshold
|humanOrthologsAboveThreshold|Number|Human Orthologs Above Threshold
|category|String|Category
|supportCount|Number|Support Count
|isMaxHumanToMouse|String|Is Max Human To Mouse
|isMaxMouseToHuman|String|Is Max Mouse To Human
|mouseOrthologsAboveThreshold|Number|Mouse Orthologs Above Threshold
|mouseCategoryForThreshold|String|Mouse Category For Threshold
|mouseSupportCountThreshold|Number|Mouse Support Count Threshold
|mgiGeneAccId|String|Mouse Gene Accession Id
|mouseGeneSymbol|String|Mouse Gene Symbol

##### GET By Mouse Gene Symbol
Get All the one-to-one orthologs mapping by mouse gene symbol or symbol list. The mouse gene symbol list should be entered with , separated in the endpoint.
Note:Parameter size can not be bigger than 600.

###### Example Request
```sh
 '/api/ortholog/one_to_one/find_by_mouse_genes?genes=A1cf' -i -X GET
```
###### Example Response
```sh
HTTP/1.1 200 OK
Content-Type: application/json
Content-Length: 405
 [
   {
      "humanGeneSymbol":"A1CF",
      "hgncAccId":"HGNC:24086",
      "humanSupportCountThreshold":5,
      "humanCategoryForThreshold":"one-to-one",
      "humanOrthologsAboveThreshold":1,
      "category":"GOOD",
      "supportCount":11,
      "isMaxHumanToMouse":"max",
      "isMaxMouseToHuman":"max",
      "mouseOrthologsAboveThreshold":1,
      "mouseCategoryForThreshold":"one-to-one",
      "mouseSupportCountThreshold":5,
      "mgiGeneAccId":"MGI:1917115",
      "mouseGeneSymbol":"A1cf"
   }
]
```

#### GET By Human Gene Symbol

Get All the one-to-one orthologs mapping by human gene symbol or symbol list. The human gene symbol list should be entered with , separated in the endpoint.
Note:Parameter size can not be bigger than 600.
###### Example Request
```sh
 '/api/ortholog/one_to_one/find_by_human_genes?genes=A1CF' -i -X GET
```
###### Example Response
```sh
 HTTP/1.1 200 OK
Content-Type: application/json
Content-Length: 405
 [
   {
      "humanGeneSymbol":"A1CF",
      "hgncAccId":"HGNC:24086",
      "humanSupportCountThreshold":5,
      "humanCategoryForThreshold":"one-to-one",
      "humanOrthologsAboveThreshold":1,
      "category":"GOOD",
      "supportCount":11,
      "isMaxHumanToMouse":"max",
      "isMaxMouseToHuman":"max",
      "mouseOrthologsAboveThreshold":1,
      "mouseCategoryForThreshold":"one-to-one",
      "mouseSupportCountThreshold":5,
      "mgiGeneAccId":"MGI:1917115",
      "mouseGeneSymbol":"A1cf"
   }
]
```
#### GET By Mgi Accession Id

Get All the one-to-one orthologs mapping by mgi accession id or mgi accession id list. The mgi accession id list should be entered with , separated in the endpoint.
Note:Parameter size can not be bigger than 600.
##### Example Request
```sh
 '/api/ortholog/one_to_one/find_by_mgi_ids?mgiIds=MGI:1917115' -i -X GET
```
##### Example Response
```sh
 HTTP/1.1 200 OK
Content-Type: application/json
Content-Length: 405
 [
   {
      "humanGeneSymbol":"A1CF",
      "hgncAccId":"HGNC:24086",
      "humanSupportCountThreshold":5,
      "humanCategoryForThreshold":"one-to-one",
      "humanOrthologsAboveThreshold":1,
      "category":"GOOD",
      "supportCount":11,
      "isMaxHumanToMouse":"max",
      "isMaxMouseToHuman":"max",
      "mouseOrthologsAboveThreshold":1,
      "mouseCategoryForThreshold":"one-to-one",
      "mouseSupportCountThreshold":5,
      "mgiGeneAccId":"MGI:1917115",
      "mouseGeneSymbol":"A1cf"
   }
]
```
#### GET By Hgnc Accession Id

Get All the one-to-one orthologs mapping by hgnc accession id or hgnc accession id list. The hgnc accession id list should be entered with , separated in the endpoint.
Note:Parameter size can not be bigger than 600.
##### Example Request
```sh
 '/api/ortholog/one_to_one/find_by_hgnc_ids?hgncIds=HGNC:24086' -i -X GET
```
##### Example Response
```sh
 HTTP/1.1 200 OK
Content-Type: application/json
Content-Length: 405
 [
   {
      "humanGeneSymbol":"A1CF",
      "hgncAccId":"HGNC:24086",
      "humanSupportCountThreshold":5,
      "humanCategoryForThreshold":"one-to-one",
      "humanOrthologsAboveThreshold":1,
      "category":"GOOD",
      "supportCount":11,
      "isMaxHumanToMouse":"max",
      "isMaxMouseToHuman":"max",
      "mouseOrthologsAboveThreshold":1,
      "mouseCategoryForThreshold":"one-to-one",
      "mouseSupportCountThreshold":5,
      "mgiGeneAccId":"MGI:1917115",
      "mouseGeneSymbol":"A1cf"
   }
]
```
#### GET All Orthologs

Get All the one-to-one ortholog

##### Example Request
```sh
 '/api/ortholog/find_all' -i -X GET
```
##### Example Response
```sh
 HTTP/1.1 200 OK
Content-Type: application/hal+json
Content-Length: 600
{
   "_embedded":{
      "orthologDtoList":[
         {
            "humanGeneSymbol":"A1CF",
            "hgncAccId":"HGNC:24086",
            "humanSupportCountThreshold":5,
            "humanCategoryForThreshold":"one-to-one",
            "humanOrthologsAboveThreshold":1,
            "category":"GOOD",
            "supportCount":11,
            "isMaxHumanToMouse":"max",
            "isMaxMouseToHuman":"max",
            "mouseOrthologsAboveThreshold":1,
            "mouseCategoryForThreshold":"one-to-one",
            "mouseSupportCountThreshold":5,
            "mgiGeneAccId":"MGI:1917115",
            "mouseGeneSymbol":"A1cf"
         }
      ]
   },
   "_links":{
      "self":{
         "href":"/api/ortholog/find_all?page=0&size=20"
      }
   },
   "page":{
      "size":20,
      "totalElements":1,
      "totalPages":1,
      "number":0
   }
}
```


#### GET All Orthologs As Tsv File

Get All the one-to-one orthologs as tsv file

##### Example Request
```sh
 '/api/ortholog/write_to_tsv_file' -i -X GET
```

#### ONE TO MANY ORTHOLOGS


#### GET By Mgi Accession Id

Get All the orthologs mapping by mgi accession id or mgi accession id list. The mgi accession id list should be entered with , separated in the endpoint. Note:Parameter size can not be bigger than 650.
##### Example Request
```sh
 '/api/ortholog/find_all_by_mgi_ids?mgiIds=MGI:1917115' -i -X GET
```
##### Example Response
```sh
 HTTP/1.1 200 OK
Content-Type: application/json
Content-Length: 405
 [
   {
      "humanGeneSymbol":"A1CF",
      "hgncAccId":"HGNC:24086",
      "humanSupportCountThreshold":5,
      "humanCategoryForThreshold":"one-to-one",
      "humanOrthologsAboveThreshold":1,
      "category":"GOOD",
      "supportCount":11,
      "isMaxHumanToMouse":"max",
      "isMaxMouseToHuman":"max",
      "mouseOrthologsAboveThreshold":1,
      "mouseCategoryForThreshold":"one-to-one",
      "mouseSupportCountThreshold":5,
      "mgiGeneAccId":"MGI:1917115",
      "mouseGeneSymbol":"A1cf"
   }
]
```



##### Lastest updates

* 2022-06-15: - endpoints changed
* 2022-06-15: - find_all_by_mgi_ids added


