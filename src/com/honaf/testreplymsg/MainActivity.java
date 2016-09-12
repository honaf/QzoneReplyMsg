package com.honaf.testreplymsg;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private ListView listView;
	private MyAdapter adapter;
	private List<Action> actionList = new ArrayList<Action>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		initListener();
		initData();

		adapter = new MyAdapter(this);
		listView.setAdapter(adapter);
//		setHeightLv(listView);

	}

	public void initView() {
		listView = (ListView) this.findViewById(R.id.listView1);
	}

	public void initData() {

		List<Message> msgList = new ArrayList<Message>();
		Message message = new Message("0-0","honaf1", "bingsky", "你妈妈喊你回家吃饭你妈妈喊你回家吃饭你妈妈喊你回家吃饭");
		Message message2 = new Message("0-1","honaf2", "qiao", "自2003年毕业于浙江大学计算机科学与技术学院以来，辗转十年一路摸索，无不");
		Message message3 = new Message("0-2","honaf3", "stefan", "项目经理，我恨你，而且我知道你也恨我。我真的不理解，你究竟是做什么的。你是一个多么独特的角色呀，几乎每个公司都要雇用你这样的人。可在不管大大小小的项目中，你与其");
		msgList.add(message);
		msgList.add(message2);
		msgList.add(message3);
		Action a1 = new Action("0", "你叫我有什么事吗？", msgList);
		
		
		
		List<Message> msgList2 = new ArrayList<Message>();
		Message message21 = new Message("1-0","honaf11", "kitty", "每月发布活跃设备排行榜，为开发者提供参考。9月份活跃安卓设备排行与8月份相比，没有太大的变化，前十位依然被三星和小米给瓜分。9月份活跃设备寡头现象更加明显。数据来自移动应用统计分析及开发者服务平台友盟（Umeng）。");
		Message message22 = new Message("1-1","honaf22", "john", "自2003年毕业于浙江大学计算机科学与技术学院以来，辗转十年一路摸索，无不");
		Message message23 = new Message("1-2","honaf33", "mike", "项目经理，我恨你，而且我知道你也恨我。我真的不理解，你究竟是做什么的。你是一个多么独特的角色呀，几乎每个公司都要雇用你这样的人。可在不管大大小小的项目中，你与其");
		
		msgList2.add(message21);
		msgList2.add(message22);
		msgList2.add(message23);
		Action a2 = new Action("1", "求美女一枚？求美女一枚？求美女一枚？求美女一枚？求美女一枚？求美女一枚？求美女一枚？", msgList2);
		
		
		List<Message> msgList3 = new ArrayList<Message>();
		Message message31 = new Message("2-0","honaf31", "小伙伴", "你妈妈喊你回家吃饭你妈妈喊你回家吃饭你妈妈喊你回家吃饭");
		Message message32 = new Message("2-1","honaf32", "吊丝逆袭", "自2003年毕业于浙江大学计算机科学与技术学院以来，辗转十年一路摸索，无不");
		Message message33 = new Message("2-2","honaf33", "你懂的", "项目经理，我恨你，而且我知道你也恨我。");
	
		msgList3.add(message31);
		msgList3.add(message32);
		msgList3.add(message33);
		Action a3 = new Action("2", "我对你的爱爱爱不完！", msgList3);

		actionList.add(a1);
		actionList.add(a2);
		actionList.add(a3);

	}

	public void initListener() {

	}
//	public void setHeightLv(ListView listView) {
//
//		ListAdapter listAdapter = listView.getAdapter();
//		int hangshu = listAdapter.getCount();
//		int totalHight = 0;
//		for (int i = 0; i < hangshu; i++) {
//			View view = listAdapter.getView(i, null, listView);
//			view.measure(View.MeasureSpec.UNSPECIFIED,
//					View.MeasureSpec.UNSPECIFIED);
//			totalHight += view.getMeasuredHeight();
//		}
//		totalHight += listView.getDividerHeight() * (hangshu - 1);
//		LayoutParams params = listView.getLayoutParams();
//		params.height = totalHight;
//
//		listView.setLayoutParams(params);
//	}
	class MyAdapter extends BaseAdapter {
		Context context;

		public MyAdapter(Context c) {
			this.context = c;
		}

		@Override
		public int getCount() {
			return actionList.size();
		}

		@Override
		public Object getItem(int position) {
			return actionList.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View view, ViewGroup parent) {
			ImgTextWrapper wrapper;
			if (view == null) {
				wrapper = new ImgTextWrapper();
				LayoutInflater inflater = LayoutInflater.from(context);
				view = inflater.inflate(R.layout.lv_item, null);
				wrapper.textView = (TextView) view.findViewById(R.id.textView1);
				wrapper.listView = (MyListView) view.findViewById(R.id.listView1);
				view.setTag(wrapper);
			} else {
				wrapper = (ImgTextWrapper) view.getTag();
			}
			wrapper.textView.setText(actionList.get(position).getAction());
			MsgAdapter msgadapter=new MsgAdapter(position, context, actionList.get(position).getMsgList());
			wrapper.listView.setAdapter(msgadapter);
//			setHeightLv(wrapper.listView);
			return view;
		}

		class ImgTextWrapper {
			TextView textView;
			MyListView listView;
		}
		
		// ==========================================================================================
		class MsgAdapter extends BaseAdapter {
			Context context;
			int gposition;
			private List<Message> msgList = new ArrayList<Message>();

			public MsgAdapter(int gposition, Context c, List<Message> msgList) {
				this.context = c;
				this.gposition = gposition;
				this.msgList = msgList;
			}

			@Override
			public int getCount() {
				return msgList.size();
			}

			@Override
			public Object getItem(int position) {
				return msgList.get(position);
			}

			@Override
			public long getItemId(int position) {
				return position;
			}

			@Override
			public View getView(int position, View view, ViewGroup parent) {
				ImgTextWrapper wrapper;
				if (view == null) {
					wrapper = new ImgTextWrapper();
					LayoutInflater inflater = LayoutInflater.from(context);
					view = inflater.inflate(R.layout.lv_item_item, null);
					wrapper.textView = (TextView) view.findViewById(R.id.textView1);
					view.setTag(wrapper);
				} else {
					wrapper = (ImgTextWrapper) view.getTag();
				}

				StringBuilder actionText = new StringBuilder();
				actionText.append("<a style=\"text-decoration:none;\" href='username'>" + msgList.get(position).getFrom() + " </a>");
				actionText.append("<a style=\"text-decoration:none;\" href='text'>" + "回复" + " </a>");
				actionText.append("<a style=\text-decoration:none;\" href='singstar'> " + msgList.get(position).getTo() + "</a>");
				actionText.append("<a style=\"text-decoration:none;\" href='star'>" + msgList.get(position).getMsg() + " </a>" + "<img src=\"file:///android_asset/images/ic_lancher.png\" />");
				// <img
				// src=\"http://t11.baidu.com/it/u=2252020396%2C3421242360&fm=56\"
				// />
				wrapper.textView.setText(Html.fromHtml(actionText.toString(), new Html.ImageGetter() {

					@Override
					public Drawable getDrawable(String source) {

						Drawable myDrawable = null;

						// try {
						// myDrawable = Drawable.createFromStream(
						// new URL(source).openStream(), "");
						//
						// } catch (IOException e) {
						// e.printStackTrace();
						// }
						//
						// myDrawable.setBounds(0, 0,
						// myDrawable.getIntrinsicWidth(),
						// myDrawable.getIntrinsicHeight());
						// myDrawable= R.drawable.ic_launcher;
						return myDrawable;

					}
				}, null));

				wrapper.textView.setMovementMethod(LinkMovementMethod.getInstance());
				CharSequence text = wrapper.textView.getText();
				int ends = text.length();
				Spannable spannable = (Spannable) wrapper.textView.getText();
				URLSpan[] urlspan = spannable.getSpans(0, ends, URLSpan.class);
				SpannableStringBuilder stylesBuilder = new SpannableStringBuilder(text);
				stylesBuilder.clearSpans(); // should clear old spans
				for (URLSpan url : urlspan) {
					MyclickSpan myURLSpan = new MyclickSpan(url.getURL(), context, wrapper.textView, gposition, position);
					stylesBuilder.setSpan(myURLSpan, spannable.getSpanStart(url), spannable.getSpanEnd(url), spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
				}
				wrapper.textView.setText(stylesBuilder);
				return view;
			}

			class ImgTextWrapper {
				TextView textView;
			}
		}

		class MyclickSpan extends ClickableSpan {

			private String content;
			private Context context;
			private TextView textview;
			private int position;
			private int gposition;

			MyclickSpan(String content, Context context, TextView textview, int gposition, int position) {
				this.content = content;
				this.context = context;
				this.textview = textview;
				this.gposition = gposition;
				this.position = position;
			}

			@Override
			public void updateDrawState(TextPaint ds) {
				super.updateDrawState(ds);
				ds.setUnderlineText(false);
				if (content.equals("username")) {
					ds.setColor(Color.BLUE);
				} else if (content.equals("singstar")) {
					ds.setColor(Color.RED);
				} else {
					ds.setColor(Color.BLACK);
				}

			}

			@Override
			public void onClick(View widget) {
				if (content.equals("username")) {
					Toast.makeText(context, actionList.get(gposition).getMsgList().get(position).getFrom(), Toast.LENGTH_SHORT).show();
					textview.setClickable(false);

				} else if (content.equals("singstar")) {
					Toast.makeText(context, actionList.get(gposition).getMsgList().get(position).getTo(), Toast.LENGTH_SHORT).show();
					textview.setClickable(false);
				} else {
					Toast.makeText(context, "all" + actionList.
							get(gposition).getMsgList().get(position).getId(), Toast.LENGTH_SHORT).show();
				}
			}
		}
	}
}
