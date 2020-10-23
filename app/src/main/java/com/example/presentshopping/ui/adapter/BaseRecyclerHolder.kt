
import android.content.Context
import android.graphics.Bitmap
import android.util.SparseArray
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.request.RequestOptions
import com.example.presentshopping.R


/**
 * Created by ${wangjiasheng} on 2017/12/22 0022.
 * * 万能的RecyclerView的ViewHolder
 */
class BaseRecyclerHolder private constructor(private val context: Context, itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val views: SparseArray<View?> = SparseArray(8)

    /**
     * 通过view的id获取对应的控件，如果没有则加入views中
     *
     * @param viewId 控件的id
     * @return 返回一个控件
     */
    fun <T : View?> getView(viewId: Int): T? {
        var view = views[viewId]
        if (view == null) {
            view = itemView.findViewById(viewId)
            views.put(viewId, view)
        }
        return view as T?
    }

    /**
     * 设置字符串
     */
    fun setText(viewId: Int, text: String?): BaseRecyclerHolder {
        val tv = getView<TextView>(viewId)!!
        tv.text = text
        return this
    }

    /**
     * 设置图片
     */
    fun setImageResource(viewId: Int, drawableId: Int): BaseRecyclerHolder {
        val iv = getView<ImageView>(viewId)!!
        //        iv.setImageResource(drawableId);
//        iv.setImageDrawable(context.getResources().getDrawable(drawableId));
        Glide.with(context).load(drawableId).into((getView<View>(viewId) as ImageView?)!!)
        return this
    }

    /**
     * 设置图片
     */
    fun setImageBitmap(viewId: Int, bitmap: Bitmap?): BaseRecyclerHolder {
        val iv = getView<ImageView>(viewId)!!
        iv.setImageBitmap(bitmap)
        return this
    }

    /**
     * 设置图片
     */
    fun setImageByUrl(viewId: Int, url: String?): BaseRecyclerHolder {
        Glide.with(context).load(url)
                .apply(RequestOptions().placeholder(R.drawable.goods).priority(Priority.HIGH))
                .into((getView<View>(viewId) as ImageView?)!!)
        return this
    }

    /**
     * 为ImageView设置网络图片
     *
     * @param context
     * @param imageView
     * @param url
     * @return
     */
    fun setImageWithGlide(context: Context?, imageView: ImageView?, url: String?) {
        Glide.with(context!!)
                .load(url)
                .apply(RequestOptions().placeholder(R.drawable.goods).priority(Priority.HIGH))
                .into(imageView!!)
    }

    /**
     * 为ImageView设置本地
     *
     * @param context
     * @param imageView
     * @param url
     * @return
     */
    fun setImageWithGlide(context: Context?, imageView: ImageView?, url: Int) {
        Glide.with(context!!)
                .load(url)
                .apply(RequestOptions().placeholder(R.drawable.goods).priority(Priority.HIGH))
                .into(imageView!!)
    }

    fun setThumbWithGlide(context: Context?, width: Int, height: Int, placeHolder: Int, imageView: ImageView?, url: String?) {
        val options = RequestOptions()
                .override(width, height)
                .placeholder(placeHolder)
                .priority(Priority.HIGH)
        Glide.with(context!!)
                .load(url)
                .thumbnail(0.1f)
                .apply(options)
                .into(imageView!!)
    }

    companion object {
        /**
         * 取得一个RecyclerHolder对象
         *
         * @param context  上下文
         * @param itemView 子项
         * @return 返回一个RecyclerHolder对象
         */
        fun getRecyclerHolder(context: Context, itemView: View): BaseRecyclerHolder {
            return BaseRecyclerHolder(context, itemView)
        }
    }

    init {
        //指定一个初始为8
    }
}