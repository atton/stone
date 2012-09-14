package chap7;
import stone.ast.BlockStmnt;
import stone.ast.ParamatorList;
import chap6.Environment;

public class Function {
	protected ParamatorList parameters;
	protected BlockStmnt body;
	protected Environment env;
	public Function(ParamatorList parameters, BlockStmnt body, Environment env) {
		this.parameters = parameters;
		this.body = body;
		this.env = env;
	}
	public ParamatorList parameters() { return parameters; }
	public BlockStmnt body() { return body; }
	public Environment makeEnv() { return new NestedEnv(env); }
	@Override public String toString() { return "<fun: " + hashCode() + ">"; }
}
