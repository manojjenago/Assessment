import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestPaginationHelper {
  @Test
  public void testSanity() throws Exception {
    PaginationHelper paginationHelper = new PaginationHelper(new Character[]{'a', 'b'}, 10);
    assertEquals(1, paginationHelper.pageCount());
    assertEquals(2, paginationHelper.itemCount());
    assertEquals(2, paginationHelper.pageItemCount(0));
    assertEquals(-1, paginationHelper.pageItemCount(1));
    assertEquals(0, paginationHelper.pageIndex(0));
    assertEquals(0, paginationHelper.pageIndex(1));
    assertEquals(-1, paginationHelper.pageIndex(2));
    assertEquals(-1, paginationHelper.pageIndex(3));
    assertEquals(-1, paginationHelper.pageIndex(100));
    assertEquals(-1, paginationHelper.pageIndex(-5));
  }
  @Test
  public void testEdgeCase3Element2Page() throws Exception {
    PaginationHelper paginationHelper = new PaginationHelper(new Character[]{'a', 'b', 'c'}, 2);
    assertEquals(2, paginationHelper.pageCount());
    assertEquals(3, paginationHelper.itemCount());
    assertEquals(2, paginationHelper.pageItemCount(0));
    assertEquals(1, paginationHelper.pageItemCount(1));
    assertEquals(-1, paginationHelper.pageItemCount(2));
    assertEquals(0, paginationHelper.pageIndex(0));
    assertEquals(0, paginationHelper.pageIndex(1));
    assertEquals(1, paginationHelper.pageIndex(2));
    assertEquals(-1, paginationHelper.pageIndex(3));
    assertEquals(-1, paginationHelper.pageIndex(100));
    assertEquals(-1, paginationHelper.pageIndex(-5));
  }
  @Test
  public void testEdgeCase4Elements2Page() throws Exception {
    PaginationHelper paginationHelper = new PaginationHelper(new Character[]{'a', 'b', 'c','d'}, 2);
    assertEquals(2, paginationHelper.pageCount());
    assertEquals(4, paginationHelper.itemCount());
    assertEquals(2, paginationHelper.pageItemCount(0));
    assertEquals(2, paginationHelper.pageItemCount(1));
    assertEquals(-1, paginationHelper.pageItemCount(2));
    assertEquals(0, paginationHelper.pageIndex(0));
    assertEquals(0, paginationHelper.pageIndex(1));
    assertEquals(1, paginationHelper.pageIndex(2));
    assertEquals(1, paginationHelper.pageIndex(3));
    assertEquals(-1, paginationHelper.pageIndex(100));
    assertEquals(-1, paginationHelper.pageIndex(-5));
  }
  @Test
  public void testEdgeCase9Elements3Page() throws Exception {
    PaginationHelper paginationHelper = new PaginationHelper(new Character[]{'a', 'b', 'c','d', 'e', 'f', 'g', 'h', 'i'}, 4);
    assertEquals(3, paginationHelper.pageCount());
    assertEquals(9, paginationHelper.itemCount());
    assertEquals(4, paginationHelper.pageItemCount(0));
    assertEquals(4, paginationHelper.pageItemCount(1));
    assertEquals(1, paginationHelper.pageItemCount(2));
    assertEquals(-1, paginationHelper.pageItemCount(3));
    assertEquals(0, paginationHelper.pageIndex(0));
    assertEquals(0, paginationHelper.pageIndex(1));
    assertEquals(0, paginationHelper.pageIndex(2));
    assertEquals(0, paginationHelper.pageIndex(3));
    assertEquals(1, paginationHelper.pageIndex(7));
    assertEquals(2, paginationHelper.pageIndex(8));
    assertEquals(-1, paginationHelper.pageIndex(100));
    assertEquals(-1, paginationHelper.pageIndex(-5));
  }
  @Test
  public void testEdgeCase1Elements1Page() throws Exception {
    PaginationHelper paginationHelper = new PaginationHelper(new Character[]{'a'}, 10);
    assertEquals(1, paginationHelper.pageCount());
    assertEquals(1, paginationHelper.itemCount());
    assertEquals(1, paginationHelper.pageItemCount(0));
    assertEquals(-1, paginationHelper.pageItemCount(1));
    assertEquals(-1, paginationHelper.pageItemCount(2));
    assertEquals(-1, paginationHelper.pageItemCount(3));
    assertEquals(0, paginationHelper.pageIndex(0));
    assertEquals(-1, paginationHelper.pageIndex(1));
    assertEquals(-1, paginationHelper.pageIndex(2));
    assertEquals(-1, paginationHelper.pageIndex(3));
    assertEquals(-1, paginationHelper.pageIndex(7));
    assertEquals(-1, paginationHelper.pageIndex(8));
    assertEquals(-1, paginationHelper.pageIndex(100));
    assertEquals(-1, paginationHelper.pageIndex(-5));
  }
}
