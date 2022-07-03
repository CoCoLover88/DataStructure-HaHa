package com.company.link;

public class Josepho {
    public static void main(String[] args) {
        CircleSingleLinkedList list = new CircleSingleLinkedList();
//        list.addBoy(6);
        list.countBoy(2, 3, 6);
//        list.showBoy();


    }
}

class CircleSingleLinkedList {
    private Boy first = null;

    public void addBoy(int nums) {
        if (nums < -1) {
            System.out.println("nums值不正确");
            return;
        }
        Boy curBoy = null;
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if (first == null) {
                first = boy;
                first.setNext(first);
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    //展示循环链表
    public void showBoy() {
        if (first == null) {
            System.out.println("循环链表为空");
            return;
        }
        Boy curBoy = first;
        while (true) {
            System.out.println(curBoy.getNo());
            if (curBoy.getNext() == first) {
                break;
            }
            curBoy = curBoy.getNext();
        }
    }

    /**
     * 约瑟夫问题
     *
     * @param startNo 开始数数的节点
     * @param countNo 间隔几个出队
     * @param nums    总孩子个数
     */
    public void countBoy(int startNo, int countNo, int nums) {
        addBoy(nums);
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("链表为空或者startNo不合法");
            return;
        }
        Boy helper = first.getNext();
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }

        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        while (true) {
            //只剩一个节点
            if (helper == first) {
                break;
            }
            for (int i = 0; i < countNo - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.println("小孩"+first.getNo()+"出圈");
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println("留在队中的小孩" + first.getNo());
    }
}

class Boy {
    private int no;
    private Boy next;

    Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }
}