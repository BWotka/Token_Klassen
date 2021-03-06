package lexer;

import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 * Low priority token, used when no other token matches.
 *
 * @author Benedikt Wotka
 */
@Catch_All
public class CatchAll extends Token {
  private String content;
  Logger lexerLog;


  public CatchAll() {
    super();
     lexerLog = Logger.getLogger("LexLoggingToken");
    pattern = Pattern.compile("^.");
  }

  /**
   * Copy Constructor, creates a new Token with the same values.
   *
   * @param oldCA original Token
   */
  public CatchAll(CatchAll oldCA) {
    this();
    content = oldCA.getContent();
  }

  @Override
  protected Token getToken() {
    lexerLog.info("Token " + this.getClass().getName() + " was used.");
    Token newCA = new CatchAll(this);
    return newCA;
  }

  @Override
  protected String getContent() {
    return content;
  }

  @Override
  protected void setContent(String pcontent) {
    content = pcontent;
  }
}
