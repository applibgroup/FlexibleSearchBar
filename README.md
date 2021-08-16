FlexibleSearchBar
=================

Introduction
------------
Scalable search bar, imitating Huawei's application market

# Source

The code in this repository was inspired from https://github.com/yuqirong/FlexibleSearchBar. We are very thankful to yuqirong.

Screenshot
----------
![screenshot](/screenshot/closed.PNG)
![screenshot](/screenshot/expand.PNG)
![screenshot](/screenshot/toast.PNG)

## Installation

In order to use the library, add the following line to your **root** gradle file:

I) For using FlexiSearchBar module in sample app, include the source code and add the below dependencies in entry/build.gradle to generate hap/support.har.
```
dependencies {
        implementation project(':flexiblesearchbarview')
        implementation fileTree(dir: 'libs', include: ['*.har'])
        testImplementation 'junit:junit:4.13'
}
```
II) For using FlexiSearchBar in separate application using har file, add the har file in the entry/libs folder and add the dependencies in entry/build.gradle file.
```
dependencies {
        implementation fileTree(dir: 'libs', include: ['*.har'])
        testImplementation 'junit:junit:4.12'
}
```

Usage
-----
I). Add `SearchBarView` in layout：

	<com.yuqirong.flexiblesearchbarview.SearchBarView
            ohos:id="$+id:flexible_search_bar_view"
            ohos:height="50vp"
            ohos:width="match_parent"
            ohos:margin="10vp"
            />


II). Usage in `startOpen()` to open searchbarview，`startClose()` to close searchbarview：

	
	SearchBarView searchbarview = (SearchBarView) findViewById(R.id.searchbarview);

	searchbarview.startOpen();; // Open Search Bar
	...
	searchbarview.startClose(); // Close Search Bar
    
    onscroll of list container:
    i) if first item is visible in listcontainer then we are closing searchbarview
    ii) if first item is not visible then we are opening searchbarview
    
    listContainer.setScrollListener(() -> {
            if (listContainer.getItemPosByVisibleIndex(0) == 0) {
                srchBrVw.startClose(); 
            } else {
                srchBrVw.startOpen();
            }
        });
	
	onclick of searchbarview:
	i) if the view is opened then we are showing Toast message:
	  
	searchbarview.setClickedListener((final Component component) -> {
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

License
-------
	Copyright (c) 2017 yuqirong 
	
	Licensed under the Apache License, Version 2.0 (the "License”);
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at
	
	http://www.apache.org/licenses/LICENSE-2.0
	
	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.