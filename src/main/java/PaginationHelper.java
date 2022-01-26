public class PaginationHelper {

  private final Character[] elements;
  private final int elementPerPage;

  /**
   * @param elements
   * @param elementPerPage
   * @throws Exception
   */
  public PaginationHelper(Character[] elements, int elementPerPage) throws Exception {
    if (elements == null || elements.length == 0) {
      throw new Exception("Elements can't be 0");
    }
    if (elementPerPage == 0) {
      throw new Exception("Page size cannot be 0");
    }
    this.elements = elements;
    this.elementPerPage = elementPerPage;
  }

  /**
   * @return total pages for the pagination
   */
  public int pageCount() {
    return (int)Math.ceil(elements.length * 1.0 /elementPerPage);
  }

  /**
   * @return total elements for the pagination
   */
  public int itemCount() {
    return elements.length;
  }

  /**
   * Check total elements per page. The elements varies especially at the last page because it might be the last elements available
   * @param pageNumber
   * @return total elements for the page requested
   */
  public int pageItemCount(int pageNumber) {
    if (pageNumber >= pageCount() || pageNumber < 0) {
      return -1;
    }
    int start = pageNumber * elementPerPage;
    int end = start + elementPerPage -1;

    if (start >= itemCount()) {
      return -1;
    } else if (end >= itemCount()) {
      return itemCount() - start;
    }
    return elementPerPage;
  }

  /**
   * Check which pages the index fall into
   * @param index
   * @return page number the index fall into
   */
  public int pageIndex(int index) {
    if (index < 0 || index >= itemCount()) {
      return -1;
    }
    return (int)Math.floor(index * 1.0 /elementPerPage);
  }
}
