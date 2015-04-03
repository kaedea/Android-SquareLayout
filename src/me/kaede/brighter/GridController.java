package me.kaede.brighter;

import java.util.Random;

import android.graphics.Color;
import android.widget.GridView;

public class GridController {
	GridView grid;
	GamingGridAdapter adapter;
	int level = 0;
	private Random random;
	int targetPosition=0;
	int normalColor=-1;
	int target=-1;
	int r,g,b;
	
	public GridController(GridView grid,GamingGridAdapter adapter) {
		this.grid = grid;
		this.adapter = adapter;
		random = new Random();
	}
	
	public void reStart(){
		this.level =0;
		nextLevel();
	}
	
	public void setColumn(int num){
		grid.setNumColumns(num);
		adapter.line=num;
		adapter.column=num;
		targetPosition = random.nextInt(num*num);
		adapter.notifyDataSetChanged();
	}
	
	/*public void setColumn(int column,int line){
		grid.setNumColumns(column);
		adapter.line=line;
		adapter.column=column;
		adapter.notifyDataSetChanged();
	}*/
	
	public void setLevel(int level){
		//关卡设置
		int column = getColumn(level);
		r = 100+random.nextInt(100);
		g = 100+random.nextInt(100);
		b = 100+random.nextInt(100);
		setColumn(column);
	}
	
	public void nextLevel(){
		level++;
		setLevel(level);
	}
	
	public void checkLevel(int position){
		if(position==targetPosition){
			//过关
			nextLevel();
		}else{
			//错误
		}
	}
	
	public int getColumn(int level){
		int column = 1;
		if(level<3){
			column =2;
		}else if(level<5){
			column =3;
		}
		else if(level<7){
			column =4;
		}else if(level<9){
			column =5;
		}else if(level<11){
			column =6;
		}else if(level<13){
			column =7;
		}else if(level<15){
			column =8;
		}else if(level<17){
			column =9;
		}else{
			column =10;
		}
		return column;
	}
	
	public Boolean checkPosition(int position){
		return position==targetPosition;
	}
	
	public int getNormalColor(){
		return Color.rgb(r,g,b);
	}
	
	public int getTargetColor(){
		return Color.rgb(r+20,g+20,b+20);
	}
	
}
