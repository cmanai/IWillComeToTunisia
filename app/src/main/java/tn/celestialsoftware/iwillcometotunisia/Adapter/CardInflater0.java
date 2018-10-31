package tn.celestialsoftware.iwillcometotunisia.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;


import tn.celestialsoftware.iwillcometotunisia.R;


public class CardInflater0 implements IAdapterViewInflater<CardItemData> {

	CardItemData item;



	@Override
	public View inflate(final BaseInflaterAdapter<CardItemData> adapter,
			final int pos, View convertView, ViewGroup parent) {
		ViewHolder holder;

		if (convertView == null) {
			LayoutInflater inflater = LayoutInflater.from(parent.getContext());
			convertView = inflater.inflate(R.layout.list_item_card, parent,
					false);

			holder = new ViewHolder(convertView);

		} else {
			holder = (ViewHolder) convertView.getTag();

		}


		item = adapter.getTItem(pos);
		holder.updateDisplay(item);

		return convertView;
	}

	private class ViewHolder {
		private View m_rootView;
		private ImageView m_text1;
		private TextView m_text2;
		private TextView m_text3;
        private TextView golder;
        private TextView silver;

		public ViewHolder(View rootView) {
			m_rootView = rootView;
			m_text1 = (ImageView) m_rootView.findViewById(R.id.ch01);
			m_text2 = (TextView) m_rootView.findViewById(R.id.Title);
            golder = (TextView) m_rootView.findViewById(R.id.pricegolden);
            silver = (TextView) m_rootView.findViewById(R.id.pricesilver);
			m_text3 = (TextView) m_rootView.findViewById(R.id.Description);

			rootView.setTag(this);
		}

		public void updateDisplay(CardItemData item) {

            m_text1.setImageResource(item.getText1());
			m_text1.setScaleType(ScaleType.FIT_XY);
			m_text2.setText(item.getText2());
			m_text3.setText(item.getText3());
            golder.setText(item.getGolden());
            silver.setText(item.getSilver());

		}

	}

}
