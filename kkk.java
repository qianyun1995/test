package kjunzhi;

import java.util.ArrayList;

public class kkk {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x[]={1,3,5,7,9};
		int y[]={2,4,6,8,10};
		Point c1=new Point(0, 0);
		Point c2=new Point(11,11);
		judge(x,y,c1,c2);
	}  


	public static void judge(int[] x,int[] y,Point c1,Point c2)
	{ 
		ArrayList<Point> f1=new ArrayList<>();
		ArrayList<Point> f2=new ArrayList<>();

		for(int i=0;i<x.length;i++)
		{   
			Point p[]=new Point[x.length];
			p[i]=new Point(x[i],y[i]);

			int d1=distance(p[i], c1);
			int d2=distance(p[i], c2);

			if(d1<=d2)
			{
				f1.add(p[i]);
			}
			else
			{
				f2.add(p[i]);
			}

		}

		Point newc1=update(f1);
		Point newc2=update(f2);

		int cd1=distance(c1,newc1);
		int cd2=distance(c2,newc2);

		if(cd1<1&&cd2<1)
		{
			System.out.println("c1ÊÇ("+c1.x+","+c1.y+")");
			System.out.println("c2ÊÇ("+c2.x+","+c2.y+")");
		}
		else
		{
			judge(x,y,newc1,newc2);
		}

	} 
	public static int distance(Point p1,Point p2)
	{
		int dt=(p1.x-p2.x)*(p1.x-p2.x)+(p1.y-p2.y)*(p1.y-p2.y);
		return dt;

	}

	public static Point update(ArrayList<Point> f)
	{   int size=f.size();
	Point p[]=new Point[size];
	int dx=0,sumx=0;
	int dy=0,sumy=0;
	for(int i=0;i<size;i++)
	{
		p[i]=f.get(i);
		sumx+=p[i].x;
		sumy+=p[i].y;
	}
	if(!(size==0)){  
		dx=sumx/size;
		dy=sumy/size;}
	Point newc=new Point(dx,dy);
	return newc;
	}
}
