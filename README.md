# PaginationHelper

PaginationHelper is a class to help pagination API. The current implementation accepts 2 parameter for the constructor:
* Elements to be paginated
* Total element per page

Once these parameters passed down, then there are 4 functions that can be called to help the pagination:
* pageCount -- get total pages
* itemCount -- get total elemests
* pageItemCount -- get elements per page including the elements at the last page
* pageIndex -- get page number based on element index

P.S. The current implementation doesn't support for 0 elements

More Details can be found inside the javadoc. Test cases have been provided as well. There are 4 scenarios provided:
* testSanity -- happy flow test case
* testEdgeCase9Elements3Page -- covering the 9 elements 3 pages, so there should be no element at page index 3
* testEdgeCase4Elements2Page -- covering the 4 elements 2 pages, so there should be no element at page index 2
* testEdgeCase3Element2Page -- covering the 3 elements 2 pages, so there should be no element at page index 2 and 1 element only at index 1
* testEdgeCase1Elements1Page -- covering the 1 elements 1 pages, so there should be no element at page index 1

<h2>How to run it:</h2>
* Ensure any JDK/JRE installed already with minimum version 1.8
* run `./gradlew test` to check the unit test
* run `./gradlew build` to build 

