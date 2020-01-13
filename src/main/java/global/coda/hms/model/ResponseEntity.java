package global.coda.hms.model;

/**
 * Custom Response entity to produce the response .
 *
 * @param <T> Generic Paramenter
 */
public class ResponseEntity<T> {
  /**
   * The Status code.
   */
  private int statusCode;
  /**
   * The Data.
   */
  private T data;


  /**
   * Instantiates a new Response entity.
   */
  public ResponseEntity() {
  }


  /**
   * Gets status code.
   *
   * @return the status code
   */
  public int getStatusCode() {
    return statusCode;
  }

  /**
   * Sets status code.
   *
   * @param statusCode the status code
   * @return the status code
   */
  public ResponseEntity setStatusCode(int statusCode) {
    this.statusCode = statusCode;
    return this;
  }

  /**
   * Gets data.
   *
   * @return the data
   */
  public T getData() {
    return data;
  }

  /**
   * Sets data.
   *
   * @param data the data
   * @return the data
   */
  public ResponseEntity setData(T data) {
    this.data = data;
    return this;
  }
}
