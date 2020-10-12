package math;

/*
 * 30 Seconds of Java code library
 *
 */
public class PagesCountSnippet {
  /**
   * Calculates how many pages required to fit items depending on page size
   *
   * @param numberOfObjects total items to split onto pages
   * @param pageSize how many items 1 page can fit
   * @return pages count
   * @throws IllegalArgumentException if pageSize <=0
   */
  public static int pagesCount(int numberOfObjects, int pageSize) throws IllegalArgumentException {
    if (pageSize <= 0) {
      throw new IllegalArgumentException("Page Size should be greater than 0");
    }
    return numberOfObjects / pageSize + (numberOfObjects % pageSize == 0 ? 0 : 1);
  }
}
