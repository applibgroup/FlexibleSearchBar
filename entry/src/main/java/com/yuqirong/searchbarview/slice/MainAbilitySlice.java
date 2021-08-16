/*
 * Copyright (C) 2020-21 Application Library Enigineering Group
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

package com.yuqirong.searchbarview.slice;

import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.BaseItemProvider;
import ohos.agp.components.Component;
import ohos.agp.components.ComponentContainer;
import ohos.agp.components.ListContainer;
import ohos.agp.components.Text;
import ohos.agp.render.layoutboost.LayoutBoost;
import ohos.agp.window.dialog.ToastDialog;
import ohos.app.Context;
import ohos.global.resource.NotExistException;
import ohos.global.resource.WrongTypeException;
import com.yuqirong.flexiblesearchbarview.SearchBarView;
import com.yuqirong.searchbarview.ResourceTable;
import java.io.IOException;

/**
 * MainAbilitySlice class.
 */
public class MainAbilitySlice extends AbilitySlice {
    /**
     * List view Data.
     */
    private String[] aplhabet;

    /**
     * onStart.
     */
    @Override
    public void onStart(final Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
        final Context mcontext = this;
        aplhabet = getContext().getStringArray(ResourceTable.Strarray_array);
        final ToastDialog toastDialog = new ToastDialog(mcontext);
        final SearchBarView srchBrVw = (SearchBarView) findComponentById(ResourceTable.Id_flexible_search_bar_view);
        srchBrVw.setClickedListener((final Component component) -> {
            if (srchBrVw.chekOpen()) {
                try {
                    String text;
                    text = getContext().getResourceManager().getElement(ResourceTable.String_enter_text).getString();
                    toastDialog.setText(text);
                } catch (IOException | NotExistException | WrongTypeException e) {
                    e.printStackTrace();
                }
                toastDialog.show();
            }
        });
        final ListContainer listContainer = (ListContainer) findComponentById(ResourceTable.Id_list);
        final CustomAdapter customAdapter = new CustomAdapter(mcontext, aplhabet);
        listContainer.setItemProvider(customAdapter);
        listContainer.setScrollListener(() -> {
            if (listContainer.getItemPosByVisibleIndex(0) == 0) {
                srchBrVw.startClose();
            } else {
                srchBrVw.startOpen();
            }
        });
    }

    /**
     * onActive.
     */
    @Override
    public void onActive() {
        super.onActive();
    }

    /**
     * onForeground.
     */
    @Override
    public void onForeground(final Intent intent) {
        super.onForeground(intent);
    }

    /**
     * Adapter bridges listcontainer.
     */
    public class CustomAdapter extends BaseItemProvider {
        /**
         * Context.
         */
        private final Context context;
        /**
         * Data.
         */
        private final String[] alpha;

        /**
         * Adapter constructor.
         *
         * @param appContext appContext
         *
         * @param args args
         */
        public CustomAdapter(final Context appContext, final String... args) {
            super();
            this.context = appContext;
            this.alpha = args.clone();
        }

        /**
         * getCount.
         */
        @Override
        public int getCount() {
            return aplhabet.length;
        }

        /**
         * getItem.
         */
        @Override
        public Object getItem(final int pos) {
            return null;
        }

        /**
         * getItemId.
         */
        @Override
        public long getItemId(final int pos) {
            return pos;
        }

        /**
         * getComponent.
         */
        @Override
        public Component getComponent(final int pos, final Component component, final ComponentContainer compoCont) {
            final Component compo = LayoutBoost.inflate(this.context, ResourceTable.Layout_mylist, null, true);
            final Text text = (Text) compo.findComponentById(ResourceTable.Id_text_view);
            text.setText(alpha[pos]);
            return compo;
        }
    }
}
