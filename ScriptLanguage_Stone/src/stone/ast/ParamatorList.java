package stone.ast;
import java.util.List;

public class ParamatorList extends ASTList {
	public ParamatorList(List<ASTree> c) { super(c); }
	public String name(int i) { return((ASTLeaf)child(i)).token().getText(); }
	public int size() { return numChildren(); }
}