[![](https://jitpack.io/v/fajaranugrah/BaseRecyclerViewAdapter.svg)](https://jitpack.io/#fajaranugrah/BaseRecyclerViewAdapter)

# BaseRecyclerViewAdapter

use Gradle:

```
implementation 'com.github.fajaranugrah:BaseRecyclerViewAdapter:version'
```

and add

```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

example one layout
```
val adapter = this@DashboardFragment.activity?.let { activity ->
            BaseRecyclerView.Builder<User>(activity, dataUser)
                ?.setContentView(R.layout.recycler_view_name_row)
                ?.setOnItemRootClickListener(object : BaseRecyclerView.OnItemRootClickListener<User> {
                    override fun onItemRootClick(var1: User, var2: Int) {
                        Log.e("onClick", "yeah click ${var1.name}")
                    }
                })
                ?.addElement(object : RecyclerViewElementTextView<User?>(R.id.tv_1) {
                    override fun getText(var1: User?): CharSequence? {
                        return var1?.name
                    }
                })
                ?.build()
        }
binding.rvResult.adapter = adapter
```

example twice layout

```
val adapter = this@DashboardFragment.activity?.let { activity ->
            BaseRecyclerView.Builder<User>(activity, dataUser)
                .setOnGetItemViewType(object : BaseRecyclerView.OnGetItemViewType<User> {
                    override fun getViewType(var1: User, var2: Int): Int {
                        return if (TYPE_SHIMMER == var1.viewType) {
                            1
                        } else {
                            0
                        }
                    }
                })
                ?.addLayoutResForViewType(0, R.layout.recycler_view_name_row)
                ?.addLayoutResForViewType(1, R.layout.recycler_view_name_shimmer_row)
                ?.setOnItemRootClickListener(object : BaseRecyclerView.OnItemRootClickListener<User> {
                    override fun onItemRootClick(var1: User, var2: Int) {
                        Log.e("onClick", "yeah click ${var1.name}")
                    }
                })
                ?.addElement(object : RecyclerViewElementTextView<User?>(R.id.tv_1) {
                    override fun getText(var1: User?): CharSequence? {
                        return var1?.name
                    }
                }, 0)
                ?.build()
        }
binding.rvResult.adapter = adapter
```
