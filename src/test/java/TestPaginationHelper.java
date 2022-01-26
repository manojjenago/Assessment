import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestPaginationHelper {

  @Test(expected = Exception.class)
  public void givenEmptyElements_whenInit_thenThrowException() throws Exception {
    PaginationHelper paginationHelper = new PaginationHelper(new Character[]{}, 10);
  }

  @Test(expected = Exception.class)
  public void givenNullElements_whenInit_thenThrowException() throws Exception {
    PaginationHelper paginationHelper = new PaginationHelper(null, 10);
  }

  @Test(expected = Exception.class)
  public void givenEmptyPageNumber_whenInit_thenThrowException() throws Exception {
    PaginationHelper paginationHelper = new PaginationHelper(new Character[]{'a', 'b'}, 0);
  }

  @Test
  public void givenTwoElements10EntryPerPages_whenInit_thenReturnNomally() throws Exception {
    PaginationHelper paginationHelper = new PaginationHelper(new Character[]{'a', 'b'}, 10);
    assertEquals(1, paginationHelper.pageCount());
    assertEquals(2, paginationHelper.itemCount());
    assertEquals(2, paginationHelper.pageItemCount(0));
    assertEquals(0, paginationHelper.pageIndex(0));
    assertEquals(0, paginationHelper.pageIndex(1));
  }

  @Test
  public void givenTwoElements10EntryPerPagesWithNegativeInput_whenCallingFunctions_thenReturnNegativeResult() throws Exception {
    PaginationHelper paginationHelper = new PaginationHelper(new Character[]{'a', 'b'}, 10);
    assertEquals(-1, paginationHelper.pageItemCount(1));
    assertEquals(-1, paginationHelper.pageItemCount(-1));
    assertEquals(-1, paginationHelper.pageIndex(-1));
    assertEquals(-1, paginationHelper.pageIndex(2));
    assertEquals(-1, paginationHelper.pageIndex(3));
    assertEquals(-1, paginationHelper.pageIndex(100));
    assertEquals(-1, paginationHelper.pageIndex(-5));
  }
  @Test
  public void givenThreeElements2EntryPerPages_whenInit_thenReturnNomally() throws Exception {
    PaginationHelper paginationHelper = new PaginationHelper(new Character[]{'a', 'b', 'c'}, 2);
    assertEquals(2, paginationHelper.pageCount());
    assertEquals(3, paginationHelper.itemCount());
    assertEquals(2, paginationHelper.pageItemCount(0));
    assertEquals(1, paginationHelper.pageItemCount(1));
    assertEquals(0, paginationHelper.pageIndex(0));
    assertEquals(0, paginationHelper.pageIndex(1));
    assertEquals(1, paginationHelper.pageIndex(2));
  }

  @Test
  public void givenThreeElements2EntryPerPagesWithNegativeInput_whenInit_thenReturnNegativeResult() throws Exception {
    PaginationHelper paginationHelper = new PaginationHelper(new Character[]{'a', 'b', 'c'}, 2);
    assertEquals(-1, paginationHelper.pageItemCount(2));
    assertEquals(-1, paginationHelper.pageIndex(-1));
    assertEquals(-1, paginationHelper.pageIndex(3));
    assertEquals(-1, paginationHelper.pageIndex(100));
    assertEquals(-1, paginationHelper.pageIndex(-5));
  }

  @Test
  public void givenFourElements2EntryPerPages_whenInit_thenReturnNomally() throws Exception {
    PaginationHelper paginationHelper = new PaginationHelper(new Character[]{'a', 'b', 'c','d'}, 2);
    assertEquals(2, paginationHelper.pageCount());
    assertEquals(4, paginationHelper.itemCount());
    assertEquals(2, paginationHelper.pageItemCount(0));
    assertEquals(2, paginationHelper.pageItemCount(1));
    assertEquals(0, paginationHelper.pageIndex(0));
    assertEquals(0, paginationHelper.pageIndex(1));
    assertEquals(1, paginationHelper.pageIndex(2));
    assertEquals(1, paginationHelper.pageIndex(3));
  }

  @Test
  public void givenFourElements2EntryPerPagesWithNegativeInput_whenInit_thenReturnNegativeResult() throws Exception {
    PaginationHelper paginationHelper = new PaginationHelper(new Character[]{'a', 'b', 'c','d'}, 2);
    assertEquals(-1, paginationHelper.pageItemCount(2));
    assertEquals(-1, paginationHelper.pageItemCount(3));
    assertEquals(-1, paginationHelper.pageItemCount(-1));
    assertEquals(-1, paginationHelper.pageIndex(100));
    assertEquals(-1, paginationHelper.pageIndex(-5));
  }

  @Test
  public void givenNineElements4EntryPerPages_whenInit_thenReturnNomally() throws Exception {
    PaginationHelper paginationHelper = new PaginationHelper(new Character[]{'a', 'b', 'c','d', 'e', 'f', 'g', 'h', 'i'}, 4);
    assertEquals(3, paginationHelper.pageCount());
    assertEquals(9, paginationHelper.itemCount());
    assertEquals(4, paginationHelper.pageItemCount(0));
    assertEquals(4, paginationHelper.pageItemCount(1));
    assertEquals(1, paginationHelper.pageItemCount(2));
    assertEquals(0, paginationHelper.pageIndex(0));
    assertEquals(0, paginationHelper.pageIndex(1));
    assertEquals(0, paginationHelper.pageIndex(2));
    assertEquals(0, paginationHelper.pageIndex(3));
    assertEquals(1, paginationHelper.pageIndex(4));
    assertEquals(1, paginationHelper.pageIndex(7));
    assertEquals(2, paginationHelper.pageIndex(8));
  }

  @Test
  public void givenNineElements4EntryPerPagesWithNegativeInput_whenInit_thenReturnNegativeResult() throws Exception {
    PaginationHelper paginationHelper = new PaginationHelper(new Character[]{'a', 'b', 'c','d', 'e', 'f', 'g', 'h', 'i'}, 4);
    assertEquals(-1, paginationHelper.pageItemCount(-1));
    assertEquals(-1, paginationHelper.pageItemCount(3));
    assertEquals(-1, paginationHelper.pageIndex(-1));
    assertEquals(-1, paginationHelper.pageIndex(9));
    assertEquals(-1, paginationHelper.pageIndex(100));
    assertEquals(-1, paginationHelper.pageIndex(-5));
  }

  @Test
  public void givenOneElements10EntryPerPages_whenInit_thenReturnNomally() throws Exception {
    PaginationHelper paginationHelper = new PaginationHelper(new Character[]{'a'}, 10);
    assertEquals(1, paginationHelper.pageCount());
    assertEquals(1, paginationHelper.itemCount());
    assertEquals(1, paginationHelper.pageItemCount(0));
    assertEquals(0, paginationHelper.pageIndex(0));
  }

  @Test
  public void givenOneElements10EntryPerPagesWithNegativeInput_whenInit_thenReturnNegativeResult() throws Exception {
    PaginationHelper paginationHelper = new PaginationHelper(new Character[]{'a'}, 10);
    assertEquals(-1, paginationHelper.pageItemCount(1));
    assertEquals(-1, paginationHelper.pageItemCount(2));
    assertEquals(-1, paginationHelper.pageItemCount(3));
    assertEquals(-1, paginationHelper.pageIndex(1));
    assertEquals(-1, paginationHelper.pageIndex(2));
    assertEquals(-1, paginationHelper.pageIndex(3));
    assertEquals(-1, paginationHelper.pageIndex(7));
    assertEquals(-1, paginationHelper.pageIndex(8));
    assertEquals(-1, paginationHelper.pageIndex(100));
    assertEquals(-1, paginationHelper.pageIndex(-5));
  }
  
}
