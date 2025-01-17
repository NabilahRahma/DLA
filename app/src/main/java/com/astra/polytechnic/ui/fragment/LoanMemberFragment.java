package com.astra.polytechnic.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.astra.polytechnic.R;
import com.astra.polytechnic.ViewModel.KoleksiViewModel;
import com.astra.polytechnic.helper.DLAHelper;
import com.astra.polytechnic.model.Koleksi;
import com.astra.polytechnic.ui.activity.BookDetailMemberActivity;
import com.astra.polytechnic.ui.activity.KeranjangActivity;
import com.astra.polytechnic.ui.activity.LoanDetailActivity;

import java.util.Collections;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoanMemberFragment extends Fragment {
    private static final String TAG = "Fragment";
    private List<Koleksi> mKoleksiList;
    private RecyclerView mRvKoleksi;
    private LoanMemberFragment.KoleksiAdapter mKoleksiAdapter = new LoanMemberFragment.KoleksiAdapter(Collections.emptyList());
    private KoleksiViewModel mNewestViewModel;
    private TextView mTextView;
    private ImageView mImageView;
    ImageView mKeranjang;
    public LoanMemberFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNewestViewModel = new ViewModelProvider(this).get(KoleksiViewModel.class);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_collection, container, false);

        // Inflate the layout for this fragment
        mImageView=view.findViewById(R.id.imageView7);
        mKeranjang= view.findViewById(R.id.icon_cart);
        mKeranjang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), KeranjangActivity.class);
                startActivity(intent);
            }
        });
        mImageView.setEnabled(false);
        mImageView.setClickable(false);
        mImageView.setFocusable(false);
        mRvKoleksi = view.findViewById(R.id.list_collection);
        mRvKoleksi.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        mRvKoleksi.setAdapter(mKoleksiAdapter);
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        mScrollView.setVisibility(View.INVISIBLE);
        mNewestViewModel.getNewest().observe(getViewLifecycleOwner(), this::updateNewestBook);
    }
    private void updateNewestBook(List<Koleksi> koleksiNewest){
        Log.d(TAG, "updateNewestBook: "+ koleksiNewest);
        mKoleksiList = DLAHelper.getNewestBook(koleksiNewest);
        mKoleksiAdapter = new LoanMemberFragment.KoleksiAdapter(mKoleksiList);
        mRvKoleksi.setAdapter(mKoleksiAdapter);
    }
    private class KoleksiAdapter extends RecyclerView.Adapter<LoanMemberFragment.KoleksiAdapter.KoleksiHolder> {
        private List<Koleksi> mKoleksis;
        ImageView mImageView;

        public KoleksiAdapter(List<Koleksi> koleksis){
            mKoleksis = koleksis;
        }
        @NonNull
        @Override
        public LoanMemberFragment.KoleksiAdapter.KoleksiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            return new LoanMemberFragment.KoleksiAdapter.KoleksiHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(@NonNull LoanMemberFragment.KoleksiAdapter.KoleksiHolder holder, int position) {
            Koleksi koleksi = mKoleksis.get(position);
            holder.onBindViewHolder(koleksi);
            Animation animation = AnimationUtils.loadAnimation(holder.itemView.getContext(), android.R.anim.fade_in);
            holder.itemView.startAnimation(animation);
        }

        @Override
        public int getItemCount() {
            return mKoleksis.size();
        }

        private class KoleksiHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
            private ImageView mBookImage;
            private TextView mBookTitle;
            private Koleksi mKoleksi;
            private TextView deskripsi;
            private String mEditableTitle;
            ImageView imageView;

            public KoleksiHolder(LayoutInflater inflater, ViewGroup parent) {
                super(inflater.inflate(R.layout.item_detail_books, parent, false));

                mBookImage = itemView.findViewById(R.id.cover_book);
                mBookTitle = itemView.findViewById(R.id.title_book);
                deskripsi=itemView.findViewById(R.id.author_book);

                itemView.setOnClickListener(this);
            }


            private void onBindViewHolder(Koleksi koleksi) {

                mEditableTitle = koleksi.getNama();
                if(mEditableTitle.length() > 25 ){
                    mBookTitle.setText(mEditableTitle.substring(0, 25));
                    deskripsi.setText(koleksi.getDeskripsi());

                }else {
                    mBookTitle.setText(koleksi.getNama());
                    deskripsi.setText(koleksi.getDeskripsi());
                }
                mKoleksi = koleksi;

            }
            @Override
            public void onClick(View v) {
//                getChildFragmentManager().beginTransaction()
//                        .setReorderingAllowed(true)
//                        .replace(R.id.fragmentContainerView, BookDetailFragment.class, null)
//                        .commit();
                Intent intent=new Intent(getContext(), BookDetailMemberActivity.class);
                intent.putExtra("id_koleksi",mKoleksi.getIdKoleksi());
                startActivity(intent);

            }
        }
    }
}
