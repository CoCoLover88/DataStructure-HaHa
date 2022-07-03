package com.company.hashtable;

public class HashTableDemo
{
    public static void main(String[] args)
    {
        HashTab hashTab = new HashTab();
        hashTab.add(new Stu(1, "jack1"));
        hashTab.add(new Stu(2, "jack2"));
        hashTab.add(new Stu(3, "jack3"));
        hashTab.add(new Stu(7, "jack7"));
        hashTab.add(new Stu(0, "jack0"));
        hashTab.list();

        hashTab.findById(2);
        hashTab.findById(8);
    }

}

class HashTab
{
    private int size = 10;
    StuLinkedList[] stuLinkedLists;

    public HashTab()
    {
        stuLinkedLists = new StuLinkedList[this.size];
        for (int i = 0; i < size; i++)
            stuLinkedLists[i] = new StuLinkedList();
    }

    public HashTab(int size)
    {
        this.size = size;
        stuLinkedLists = new StuLinkedList[size];
        for (int i = 0; i < size; i++)
            stuLinkedLists[i] = new StuLinkedList();
    }

    /*hash表添加元素*/
    public void add(Stu stu)
    {
        int no = hashCp(stu.getId());
        stuLinkedLists[no].add(stu);
    }

    /*遍历hash表*/
    public void list()
    {
        for (int i = 0; i < size; i++)
        {
            stuLinkedLists[i].list(i);
        }
    }

    /*hash表查找*/
    public void findById(int no)
    {
        int index = no % size;
        StuLinkedList list = stuLinkedLists[index];
        Stu temp = list.head;
        boolean flag = false;
        while (temp != null)
        {
            if (temp.getId() == no)
            {
                flag = true;
                break;
            }
            if (temp.next == null)
                break;
            temp = temp.next;
        }
        if (flag)
            System.out.println("第" + index + "链表," + "id=" + temp.getId() + "name=" + temp.getName());
        else
            System.out.println("不存在该id:" + no);


    }

    /*计算hash值,采用取模方法*/
    public int hashCp(int no)
    {
        return no % size;
    }

}

class StuLinkedList
{
    Stu head;

    public StuLinkedList()
    {
        head = null;
    }

    public void add(Stu stu)
    {
        if (head == null)
        {
            head = stu;
            return;
        }
        Stu temp = head;
        while (temp.next != null)
        {
            temp = temp.next;
        }
        temp.next = stu;
    }

    public void list(int no)
    {
        if (head == null)
        {
            System.out.println("链表为空");
            return;
        }
        Stu temp = head;
        System.out.print(no + "链表信息为");
        while (temp != null)
        {
            System.out.printf("--->%d:%s", temp.getId(), temp.getName());
            temp = temp.next;
        }
        System.out.println();
    }

}

class Stu
{
    private int id;
    private String name;
    public Stu next;

    public Stu(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
