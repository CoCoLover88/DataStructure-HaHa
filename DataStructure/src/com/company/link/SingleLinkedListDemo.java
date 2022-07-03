package com.company.link;

import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        list.addByOrder(new HeroNode(1, "A", "AA"));
        list.addByOrder(new HeroNode(3, "C", "CC"));
        list.addByOrder(new HeroNode(2, "B", "BB"));
        list.list();

        //逆序打印链表
        list.printTailToHead(list.getHead());

//        list.reverse(list.getHead());
//        list.list();




        /*求单链表中有效节点的个数*/
//        System.out.println(list.getLength());
//        System.out.println(list.findLastIndexNode(2));
    }
}

class SingleLinkedList {
    private HeroNode head = new HeroNode(0, "", "");

    /*获取头节点*/
    public HeroNode getHead() {
        return head;
    }

    /*添加结点*/
    public void add(HeroNode heroNode) {
        HeroNode tempNode = head;
        while (tempNode.next != null) {
            tempNode = tempNode.next;
        }
        tempNode.next = heroNode;
    }

    /*顺序添加,不能重复添加编号*/
    public void addByOrder(HeroNode heroNode) {
        HeroNode tempNode = head;
        boolean flag = false; //编号是否重复
        while (true) {
            /*位于链表尾*/
            if (tempNode.next == null) {
                break;
            }
            if (tempNode.next.id > heroNode.id) {
                break;
            } else if (tempNode.next.id == heroNode.id) {
                flag = true;
                break;
            }
            tempNode = tempNode.next;
        }
        if (flag) {
            System.out.println("编号" + heroNode.id + "已经存在");
            System.exit(-1);
        } else {
            heroNode.next = tempNode.next;
            tempNode.next = heroNode;
        }
    }

    /*根据 id 修改结点信息 */
    public void modify(HeroNode heroNode) {
        if (isEmpty()) {
            System.out.println("list is Empty");
            System.exit(-1);
        }
        HeroNode tempNode = head.next;
        boolean flag = false;
        while (true) {
            if (tempNode == null) {
                break;
            }
            if (tempNode.id == heroNode.id) {
                flag = true;
                break;
            }
            tempNode = tempNode.next;
        }
        if (flag) {
            tempNode.name = heroNode.name;
            tempNode.nickname = heroNode.nickname;
        } else {
            System.out.println("该节点不存在");
        }
    }

    /*删除节点*/
    public void delete(int id) {
        if (isEmpty()) {
            System.out.println("list is Empty");
            System.exit(-1);
        }
        HeroNode tempNode = head;
        boolean flag = false;
        while (true) {
            if (tempNode.next == null) {
                break;
            }
            if (tempNode.next.id == id) {
                flag = true;
                break;
            }
            tempNode = tempNode.next;
        }
        if (flag) {
            tempNode.next = tempNode.next.next;
        } else {
            System.out.println("要删除的节点不存在！");
        }
    }

    /*求单链表中有效节点的个数*/
    public int getLength() {
        if (isEmpty()) {
            System.out.println("list is empty");
            return -1;
        }
        int length = 0;
        HeroNode tempNode = head;
        while (true) {
            if (tempNode.next == null) {
                break;
            }
            length++;
            tempNode = tempNode.next;
        }
        return length;
    }

    /*查找单链表中的倒数第k个节点*/
    public HeroNode findLastIndexNode(int index) {
        if (isEmpty()) {
            System.out.println("list is empty");
            return null;
        }

        int size = getLength();
        if (index <= 0 || index > size) {
            System.out.println("index is invalid");
            return null;
        }
        HeroNode tempNode = head.next;
        for (int i = 0; i < size - index; i++) {
            tempNode = tempNode.next;
        }
        return tempNode;
    }

    /*链表反转*/
    public void reverse(HeroNode heroNode) {
        if (heroNode.next == null) {
            System.out.println("list is empty");
            System.exit(-1);
        }
        HeroNode curNode = heroNode.next;
        HeroNode nextNode = null;
        HeroNode reverseNode = new HeroNode(0, "", "");
        while (curNode != null) {
            nextNode = curNode.next;
            curNode.next = reverseNode.next;
            reverseNode.next = curNode;
            curNode = nextNode;
        }
        heroNode.next = reverseNode.next;
    }

    /*从尾到头打印单链表【百度，要求方式1：反向遍历。方式2：Stack栈】
     * 不建议使用方式1
     * */
    public void printTailToHead(HeroNode heroNode) {
        if (heroNode.next == null) {
            System.out.println("list is empty");
            System.exit(-1);
        }
        Stack<HeroNode> stack = new Stack<>();
        HeroNode tempNode = heroNode.next;
        while (true) {
            if (tempNode == null) {
                break;
            }
            stack.push(tempNode);
            tempNode = tempNode.next;
        }
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }

    /*遍历链表*/
    public void list() {
        if (isEmpty()) {
            System.out.println("list is empty");
            System.exit(-1);
        }
        HeroNode tempNode = head.next;
        while (true) {
            if (tempNode == null) {
                break;
            }
            System.out.println(tempNode);
            tempNode = tempNode.next;
        }
    }

    public boolean isEmpty() {
        return head.next == null;
    }
}

/*单链表结点*/
class HeroNode {
    int id;
    String name;
    String nickname;
    HeroNode next;

    HeroNode(int id, String name, String nickname) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
