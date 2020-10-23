
import BaseRecyclerHolder
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.util.*

/**
 * 万能的RecyclerView适配器
 */
abstract class BaseRecyclerAdapter<T>(
//上下文
        private val context: Context?, //数据源
        private var list: MutableList<T>?, //布局id
        private val itemLayoutId: Int
) : RecyclerView.Adapter<BaseRecyclerHolder>() {
    protected var listener: OnItemClickListener<T>? = null
    private val inflater //布局器
            : LayoutInflater = LayoutInflater.from(context)
    private val isScrolling //是否在滚动
            = false

    private var recyclerView: RecyclerView? = null
    private var selectedPosition = -1
    fun setSelectedPosition(position: Int) {
        selectedPosition = position
    }

    //在RecyclerView提供数据的时候调用
    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        this.recyclerView = recyclerView
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        this.recyclerView = null
    }

    /**
     * 插入一项
     *
     * @param item
     * @param position
     */
    fun insert(item: T, position: Int) {
        list!!.add(position, item)
        notifyItemInserted(position)
    }

    /**
     * 删除一项
     *
     * @param position 删除位置
     */
    fun delete(position: Int) {
        list!!.removeAt(position)
        notifyItemRemoved(position)
    }

    /**
     * 修改一项
     *
     * @param position 删除位置
     */
    fun change(item: T, position: Int) {
        list!![position] = item
        notifyItemInserted(position)
    }

    /**
     * 获取某一项的数据
     *
     * @param position
     * @return
     */
    fun getitem(position: Int): T {
        return list!![position]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseRecyclerHolder {
        val view = inflater.inflate(itemLayoutId, parent, false)
        return BaseRecyclerHolder.getRecyclerHolder(context!!, view)
    }

    override fun onBindViewHolder(holder: BaseRecyclerHolder, position: Int) {
        if (listener != null) {
            //      holder.itemView.setBackgroundResource(R.drawable.recycler_bg);//设置背景
        }

        convert(holder, list!![position], position, isScrolling, selectedPosition)
        holder.itemView.setOnClickListener { view: View? ->
            if (listener != null && view != null && recyclerView != null) {
//                    int position = recyclerView.getChildAdapterPosition(view);
                listener!!.onItemClick(holder, list!![position], position)
            }
        }
    }

    override fun getItemCount(): Int {
        return if (list == null) 0 else list!!.size
    }

    interface OnItemClickListener<T> {
        fun onItemClick(viewHolder: BaseRecyclerHolder?, data: T, position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener<T>?) {
        this.listener = listener
    }

    /**
     * 填充RecyclerView适配器的方法，子类需要重写
     *
     * @param holder      ViewHolder
     * @param data        子项
     * @param position    位置
     * @param isScrolling 是否在滑动
     */
    abstract fun convert(holder: BaseRecyclerHolder?, data: T, position: Int, isScrolling: Boolean, selectedPosition: Int)
    fun setData(data: List<T>?) {
        if (null == list) {
            list = ArrayList()
        }
        list!!.addAll(data!!)
        notifyDataSetChanged()
    }

    fun clear() {
        if (null != list) list!!.clear()
        notifyDataSetChanged()
    }

    fun setNewData(data: List<T>?) {
        clear()
        setData(data)
    }

    init {


    }
}