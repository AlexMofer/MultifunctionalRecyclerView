/*
 * Copyright (C) 2018 AlexMofer
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.am.widget.ui.multifunctionalrecyclerview;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.am.appcompat.app.AppCompatActivity;
import com.am.widget.multifunctionalrecyclerview.MultifunctionalLinearLayoutManager;
import com.am.widget.multifunctionalrecyclerview.MultifunctionalRecyclerView;
import com.am.widget.ui.R;

public class MultifunctionalRecyclerViewActivity extends AppCompatActivity {

    private final Adapter mAdapter = new Adapter();
    private MultifunctionalRecyclerView mVContent;
    private MultifunctionalLinearLayoutManager mManager;

    public MultifunctionalRecyclerViewActivity() {
        super(R.layout.activity_multifunctionalrecyclerview);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolbar(R.id.mrv_toolbar);
        mVContent = findViewById(R.id.mrv_rv_content);
        final int gap = 20;
        mManager = new MultifunctionalLinearLayoutManager(this);
        mManager.setLayoutInCenter(true);
        mManager.setChildMaxSize(mAdapter.getChildMaxWidth(), mAdapter.getChildMaxHeight());
        mManager.setDecorationMaxWidthOfChildWithMaxSize(gap, gap, gap, gap);
        mVContent.setLayoutManager(mManager);
        mVContent.addItemDecoration(new ItemDecoration(gap));
        mVContent.setScaleEnable(true);
        mVContent.setScaleRange(1, 6);

        mVContent.setAdapter(mAdapter);
    }

    @Override
    protected boolean onToolbarMenuItemClick(@NonNull MenuItem item) {
        final int id = item.getItemId();
        if (id == R.id.mrv_vertical_continuity) {
            mManager.setOrientation(RecyclerView.VERTICAL);
            mManager.setPagingEnable(false);
            mVContent.invalidateItemDecorations();
            return true;
        } else if (id == R.id.mrv_vertical_singular) {
            mManager.setOrientation(RecyclerView.VERTICAL);
            mManager.setPagingEnable(true);
            mVContent.invalidateItemDecorations();
            return true;
        } else if (id == R.id.mrv_horizontal_continuity) {
            mManager.setOrientation(RecyclerView.HORIZONTAL);
            mManager.setPagingEnable(false);
            mVContent.invalidateItemDecorations();
            return true;
        } else if (id == R.id.mrv_horizontal_singular) {
            mManager.setOrientation(RecyclerView.HORIZONTAL);
            mManager.setPagingEnable(true);
            mVContent.invalidateItemDecorations();
            return true;
        }
        return super.onToolbarMenuItemClick(item);
    }
}
