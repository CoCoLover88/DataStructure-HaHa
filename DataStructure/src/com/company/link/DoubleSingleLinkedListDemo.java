package com.company.link;

import java.util.Stack;

public class DoubleSingleLinkedListDemo {
    public static void main(String[] args) {
        DoubleSingleLinkedList list = new DoubleSingleLinkedList();
        list.add(new DuHeroNode(1, "A", "AA"));
        list.add(new DuHeroNode(3, "C", "CC"));
        list.add(new DuHeroNode(2, "B", "BB"));
        list.list();
        System.out.println();
        //顺序添加
        list.addByOrder(new DuHeroNode(5, "A", "AA"));
        list.addByOrder(new DuHeroNode(4, "C", "CC"));
        list.addByOrder(new DuHeroNode(6, "B", "BB"));
        list.list();

        System.out.println();
        //删除节点
        list.delete(5);
        list.delete(4);
        list.delete(6);
        list.list();


        //逆序打印链表
//        list.list();

//        list.reverse(list.getHead());
//        list.list();
    }
}

class DoubleSingleLinkedList {
    private DuHeroNode head = new DuHeroNode(0, "", "");

    /*获取头节点*/
    public DuHeroNode getHead() {
        return head;
    }

    /*添加结点,链尾添加*/
    public void add(DuHeroNode duHeroNode) {
        DuHeroNode tempNode = head;
        while (tempNode.next != null) {
            tempNode = tempNode.next;
        }
        tempNode.next = duHeroNode;
        duHeroNode.pre = tempNode;

    }

    /*顺序添加,不能重复添加编号*/
    public void addByOrder(DuHeroNode duHeroNode) {
        DuHeroNode tempNode = head;
        boolean flag = false; //编号是否重复
        while (true) {
            /*位于链表尾*/
            if (tempNode.next == null) {
                break;
            }
            if (tempNode.next.id > duHeroNode.id) {
                break;
            } else if (tempNode.next.id == duHeroNode.id) {
                flag = true;
                break;
            }
            tempNode = tempNode.next;
        }
        if (flag) {
            System.out.println("编号" + duHeroNode.id + "已经存在");
            System.exit(-1);
        } else {
//            duHeroNode.next = tempNode.next;
//            tempNode.next = duHeroNode;
            if (tempNode.next == null) {
                tempNode.next = duHeroNode;
                duHeroNode.pre = tempNode;
            } else {
                tempNode.next.pre = duHeroNode;
                duHeroNode.pre = tempNode;
                duHeroNode.next = tempNode.next;
                tempNode.next = duHeroNode;
            }
        }
    }

    /*根据 id 修改结点信息 */
    public void modify(DuHeroNode duHeroNode) {
        if (duHeroNode.next == null) {
            System.out.println("list is Empty");
            System.exit(-1);
        }
        DuHeroNode tempNode = head.next;
        boolean flag = false;
        while (true) {
            if (tempNode == null) {
                break;
            }
            if (tempNode.id == duHeroNode.id) {
                flag = true;
                break;
            }
            tempNode = tempNode.next;
        }
        if (flag) {
            tempNode.name = duHeroNode.name;
            tempNode.nickname = duHeroNode.nickname;
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
        DuHeroNode tempNode = head.next;
        boolean flag = false;
        while (true) {
            if (tempNode == null) {
                break;
            }
            if (tempNode.id == id) {
                flag = true;
                break;
            }
            tempNode = tempNode.next;
        }
        if (flag) {
            if (tempNode.next == null) {
                tempNode.pre.next = tempNode.next;
                tempNode.pre = null;
            } else {
                tempNode.pre.next = tempNode.next;
                tempNode.next.pre = tempNode.pre;
            }
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
        DuHeroNode tempNode = head;
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
    public DuHeroNode findLastIndexNode(int index) {
        if (isEmpty()) {
            System.out.println("list is empty");
            return null;
        }

        int size = getLength();
        if (index <= 0 || index > size) {
            System.out.println("index is invalid");
            return null;
        }
        DuHeroNode tempNode = head.next;
        for (int i = 0; i < size - index; i++) {
            tempNode = tempNode.next;
        }
        return tempNode;
    }

    /*链表反转*/
    /*public void reverse(HeroNode heroNode) {
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
    }*/

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
        DuHeroNode tempNode = head.next;
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

class DuHeroNode {
    int id;
    String name;
    String nickname;
    DuHeroNode next;
    DuHeroNode pre;

    DuHeroNode(int id, String name, String nickname) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "DuHeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
