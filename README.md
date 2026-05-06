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



#### GET All Orthologs As Tsv File

Get All the orthologs as tsv file

##### Example Request
```sh
 '/api/ortholog/write_to_tsv_file' -i -X GET
```



#### GET All One To One Impc Orthologs As Tsv File

Get All the one-to-one Impc orthologs as tsv file

##### Example Request
```sh
 '/api/ortholog/one_to_one/Impc/write_to_tsv_file' -i -X GET
```



#### MOUSE GENES

This section describes endpoints that return raw mouse-gene records from the `mouse_gene`
table — no ortholog/mapping joins. Used by downstream services that need basic gene metadata
without the ortholog payload.

##### Full Mouse Gene Fields

The "full" endpoints below return all 21 fields below. JSON keys are camelCase and ordered
alphabetically.

| Path | Type | Description |
| ------ | ------ | ------ |
| ensemblChromosome | String | Ensembl Chromosome (raw value as stored in DB, no `chr` prefix) |
| ensemblGeneAccId | String | Ensembl Gene Accession Id |
| ensemblStart | Number | Ensembl Start |
| ensemblStop | Number | Ensembl Stop |
| ensemblStrand | String | Ensembl Strand |
| entrezGeneAccId | Number | Entrez Gene Accession Id |
| genomeBuild | String | Genome Build |
| mgiChromosome | String | MGI Chromosome |
| mgiCm | String | MGI cM Position |
| mgiGeneAccId | String | MGI Gene Accession Id |
| mgiStart | Number | MGI Start |
| mgiStop | Number | MGI Stop |
| mgiStrand | String | MGI Strand |
| name | String | Mouse Gene Name |
| ncbiChromosome | String | NCBI Chromosome |
| ncbiStart | Number | NCBI Start |
| ncbiStop | Number | NCBI Stop |
| ncbiStrand | String | NCBI Strand |
| subtype | String | Mouse Gene Subtype |
| symbol | String | Mouse Gene Symbol |
| type | String | Mouse Gene Type |

##### Full Mouse Gene By Mgi Accession Ids (GET)

Look up full mouse-gene records by a comma-separated list of MGI accession ids in the
query string. Note: Parameter size can not be bigger than 650.

###### Example Request
```sh
'/api/ortholog/mouse_genes/find_full_by_mgi_ids?mgiIds=MGI:1916649,MGI:1919306' -i -X GET
```
###### Example Response
```sh
HTTP/1.1 200 OK
Content-Type: application/json
[
  {
    "ensemblChromosome": "1",
    "ensemblGeneAccId": "ENSMUSG00000032666",
    "ensemblStart": 151728154,
    "ensemblStop": 151965876,
    "ensemblStrand": "-",
    "entrezGeneAccId": 69399,
    "genomeBuild": "GRCm39",
    "mgiChromosome": "1",
    "mgiCm": "64.43",
    "mgiGeneAccId": "MGI:1916649",
    "mgiStart": 151760275,
    "mgiStop": 151967941,
    "mgiStrand": "-",
    "name": "RIKEN cDNA 1700025G04 gene",
    "ncbiChromosome": "1",
    "ncbiStart": 151760275,
    "ncbiStop": 151967941,
    "ncbiStrand": "-",
    "subtype": "protein coding gene",
    "symbol": "1700025G04Rik",
    "type": "Gene"
  }
]
```

##### Full Mouse Gene By Mgi Accession Ids (POST)

Same as the GET above, but the MGI ids are sent as a JSON array in the request body. Prefer
this variant for large lists. Note: Parameter size can not be bigger than 650, and a
production WAF in front of gentar.org may reject request bodies larger than ~7.5 KB
(~500 ids); chunk client-side if you have more.

###### Example Request
```sh
curl -X POST '/api/ortholog/mouse_genes/find_full_by_mgi_ids' \
  -H 'Content-Type: application/json' \
  -d '["MGI:1916649","MGI:1919306"]'
```
Response shape is identical to the GET variant.

##### Full Mouse Genes By Symbols Or Acc Ids (POST)

Look up full mouse-gene records by a JSON array of inputs that may be either symbols or MGI
accession ids. Match is case-sensitive set membership (equivalent to the upstream GraphQL
`_in` semantics). Note: Parameter size can not be bigger than 650; same ~7.5 KB body cap
applies in production.

###### Example Request
```sh
curl -X POST '/api/ortholog/mouse_genes/find_by_symbols_or_acc_ids' \
  -H 'Content-Type: application/json' \
  -d '["1700025G04Rik","MGI:1919306"]'
```
Response shape is identical to the previous endpoint (alphabetical by symbol).

##### Full Mouse Gene By Symbol Or Acc Id (GET)

Look up full mouse-gene records by a single symbol or MGI accession id. Match is
case-insensitive equality (equivalent to the upstream GraphQL `_ilike` with no `%`
wildcards). Returns a list because in edge cases the same input string can resolve to more
than one row.

###### Example Request
```sh
'/api/ortholog/mouse_genes/find_by_symbol_or_acc_id?input=mgi:1916649' -i -X GET
```
###### Example Response
```sh
HTTP/1.1 200 OK
Content-Type: application/json
[
  {
    "ensemblChromosome": "1",
    "ensemblGeneAccId": "ENSMUSG00000032666",
    "ensemblStart": 151728154,
    "ensemblStop": 151965876,
    "ensemblStrand": "-",
    "entrezGeneAccId": 69399,
    "genomeBuild": "GRCm39",
    "mgiChromosome": "1",
    "mgiCm": "64.43",
    "mgiGeneAccId": "MGI:1916649",
    "mgiStart": 151760275,
    "mgiStop": 151967941,
    "mgiStrand": "-",
    "name": "RIKEN cDNA 1700025G04 gene",
    "ncbiChromosome": "1",
    "ncbiStart": 151760275,
    "ncbiStop": 151967941,
    "ncbiStrand": "-",
    "subtype": "protein coding gene",
    "symbol": "1700025G04Rik",
    "type": "Gene"
  }
]
```

##### Full Mouse Genes By Synonym (GET)

Look up full mouse-gene records via the `mouse_gene_synonym` join table. Match is
case-insensitive equality on `synonym`.

###### Example Request
```sh
'/api/ortholog/mouse_genes/find_by_synonym?synonym=Cof' -i -X GET
```
###### Example Response
```sh
HTTP/1.1 200 OK
Content-Type: application/json
[
  {
    "ensemblChromosome": "19",
    "ensemblGeneAccId": "ENSMUSG00000056201",
    "ensemblStart": 5540483,
    "ensemblStop": 5545229,
    "ensemblStrand": "+",
    "entrezGeneAccId": 12631,
    "genomeBuild": "GRCm39",
    "mgiChromosome": "19",
    "mgiCm": "4.34",
    "mgiGeneAccId": "MGI:101757",
    "mgiStart": 5540483,
    "mgiStop": 5544059,
    "mgiStrand": "+",
    "name": "cofilin 1, non-muscle",
    "ncbiChromosome": "19",
    "ncbiStart": 5540483,
    "ncbiStop": 5544059,
    "ncbiStrand": "+",
    "subtype": "protein coding gene",
    "symbol": "Cfl1",
    "type": "Gene"
  }
]
```


##### Lastest updates

* 2026-05-06: - mouse_genes/find_full_by_mgi_ids (GET+POST), find_by_symbols_or_acc_ids
  (POST), find_by_symbol_or_acc_id (GET), find_by_synonym (GET) added.
* 2022-06-29: - one_to_one/impc/write_to_tsv_file endpoint added.
* 2022-06-15: - find_all_by_mgi_ids added.


