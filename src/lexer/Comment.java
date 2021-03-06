package lexer;

import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 * High priority token , recognizes single line comments.
 *
 * @author Benedikt Wotka
 */
@Prio(value = 1)
public class Comment extends Token {
  private String content;
  Logger lexerLog;

  public Comment() {
    super();
    lexerLog = Logger.getLogger("LexLoggingToken");
    pattern = Pattern.compile("^//.*($|\\n)");
  }

  /**
   * Copy Constructor, creates a new Token with the same values.
   *
   * @param oldCom original Token
   */
  public Comment(Comment oldCom) {
    this();
    content = oldCom.getContent();
  }

  @Override
  protected Token getToken() {
    lexerLog.info("Token " + this.getClass().getName() + " was used.");
    Token newCom = new Comment(this);
    return newCom;
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
