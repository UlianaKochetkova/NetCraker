package task4;


public class BinaryTree {
    BinaryTree leftchild=null;
    BinaryTree rightchild=null;
    String data;
    
    public BinaryTree(String data){
        this.data=data;
    }
    public void addLeftChild(BinaryTree lc){
        leftchild=lc;
    }
    public void addRightChild(BinaryTree rc){
        rightchild=rc;
    }
    
    public void preOrder(){
        OrderLength ob=new OrderLength();
        ob.preOrder(this);
    }
    public void postOrder(){
        OrderLength ob=new OrderLength();
        ob.postOrder(this);
    }
    public void centerOrder(){
        OrderLength ob=new OrderLength();
        ob.centerOrder(this);
    }
    public int lengthTree(){
        OrderLength ob=new OrderLength();
        return ob.lengthTree(this,0);
    }
    
    //Вложенный класс с методами обхода и подсчетом длины дерева
    private class OrderLength{
        //Прямой обход
        private void preOrder(BinaryTree root){
        if (root==null){
            return;
        }
        System.out.println(root.data);
        preOrder(root.leftchild);
        preOrder(root.rightchild);
        }
        
        //Обратный обход
        private void postOrder(BinaryTree root){
            if (root==null){
                return;
            }
            postOrder(root.leftchild);
            postOrder(root.rightchild);
            System.out.println(root.data);
        }
        
        //Центрированный обход
        private void centerOrder(BinaryTree root){
            if (root==null){
                return;
            }
            centerOrder(root.leftchild);
            System.out.println(root.data);
            centerOrder(root.rightchild);
        }
        
        //Длина дерева как максимальная длина ветви от вызываемого объекта
        private int lengthTree(BinaryTree root, int l){
            if (root==null){
                return l;
            }
            int lmax=lengthTree(root.leftchild, l+1);
            int rmax=lengthTree(root.leftchild, l+1);
            return lmax>rmax?lmax:rmax;
        }
    }
    
     public static void main(String[] args) {
        //Создадим дерево для теста.
        //Каждый узел содержит в себе строку данных. В данном случае это будет название узла
        //Структура тестового дерева:
        /*
                     root
            left             right
        lleft   lright
        */
        BinaryTree root=new BinaryTree("root");
        BinaryTree left=new BinaryTree("left");
        BinaryTree right=new BinaryTree("right");
        root.addLeftChild(left);
        root.addRightChild(right);
        left.addLeftChild(new BinaryTree("lleft"));
        left.addRightChild(new BinaryTree("lright"));
        
        System.out.println("Прямой обход: ");
        root.preOrder();
        System.out.println("Обратный обход: ");
        root.postOrder();
        System.out.println("Центрированный обход: ");
        root.centerOrder();
        
        System.out.println("Длина дерева: "+root.lengthTree()+"");
    }
}

