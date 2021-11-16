package com.ming.dataStruct;

/**
 * 表达式二叉树
 */
class ExpData{
    //元素值
    int value;
    // 单字符运算符
    char oper;
    public ExpData(int value,char oper){
        this.value = value;
        this.oper = oper;
    }

    @Override
    public String toString() {
        return "ExpData{" +
                "value=" + value +
                ", oper=" + oper +
                '}';
    }
}
public class ExpressionBTree extends BTree<ExpData> {
    public ExpressionBTree(){
        super();
    }
    private int i = 0;
    // 以前缀表达式prefix构造表达式二叉树
    public ExpressionBTree(String prefix){
        this.root = createPrefix(prefix);
    }
    /**
     * 以从prefix的第i个字符开始的浅醉表达式字串，构造子表达式二叉树
     * 返回所建子树的根节点，递归算法
     */
    private BTreeNode<ExpData> createPrefix(String prefix){
        BTreeNode<ExpData> p = null;
        if(i<prefix.length()){
            char ch = prefix.charAt(i);
            // 遇到数字字符
            if (ch>'0' && ch<='9'){
                int value = 0;
                // 将整数字符串转换为整数值
                while (i<prefix.length() && ch!=' '){
                    value = value*10 + ch-'0';
                    i++;
                    if (i<prefix.length())
                        ch = prefix.charAt(i);
                }
                // 创建数值结点，叶子
                p = new BTreeNode<ExpData>(new ExpData(value,' '));
                // 跳过整数后的一个空格
                i++;
            }else {
                // 创建运算符节点，2度节点
                p = new BTreeNode<ExpData>(new ExpData(0,prefix.charAt(i)));
                i++;
                // 创建左子树，递归调用
                p.left = createPrefix(prefix);
                // 创建右子树，递归调用
                p.right =createPrefix(prefix);
            }
        }
        return p;
    }

    //计算算术表达式，返回整数值
    public int toValue(){
        return this.toValue(this.root);
    }
    public int toValue(BTreeNode<ExpData> p){
        if (p==null)
            return 0;
        if (!p.isLeaf())
            switch (p.data.oper){
                case '+': p.data.value=toValue(p.left) + toValue(p.right); break;
                case '-': p.data.value=toValue(p.left) - toValue(p.right); break;
                case '*': p.data.value=toValue(p.left) * toValue(p.right); break;
                case '/': p.data.value=toValue(p.left) / toValue(p.right); break;
            }
        return p.data.value;
    }

    // 不支持插入节点，删除子树方法，省略
    public static void main(String args[]){
        String prefix = "-+45 *-10 15 /+25 35 -60 40 11"; //前缀表达式
        ExpressionBTree expressionBTree = new ExpressionBTree(prefix);
        System.out.println("前缀表达式:    ");
        expressionBTree.preorder();
        System.out.println("中缀表达式:    ");
        expressionBTree.inorder();
        System.out.println("后缀表达式:    ");
        expressionBTree.postorder();
        System.out.println("value = " + expressionBTree.toValue());
    }


}
