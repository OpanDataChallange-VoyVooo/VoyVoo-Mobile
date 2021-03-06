package uz.lars_lion.voyvoo.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import uz.lars_lion.voyvoo.databinding.RvItemBinding
import uz.lars_lion.voyvoo.model.Person

@SuppressLint("SetTextI18n")
class ItemRvAdapter(
) : RecyclerView.Adapter<ItemRvAdapter.CreatePageViewHolder>() {

    private var dataList = ArrayList<Person>()
    private var listener: ItemOnClickListener? = null


    fun onClickListener(listener: ItemOnClickListener) {
        this.listener = listener
    }

    private val diffCallBack = object : DiffUtil.ItemCallback<Person>() {
        override fun areItemsTheSame(
            oldItem: Person,
            newItem: Person
        ): Boolean =
            oldItem.name == newItem.name

        override fun areContentsTheSame(
            oldItem: Person,
            newItem: Person
        ): Boolean =
            oldItem == newItem
    }
    private val differ = AsyncListDiffer(this, diffCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CreatePageViewHolder(
            RvItemBinding.inflate(LayoutInflater.from(parent.context)),
            listener
        )

    override fun onBindViewHolder(holder: CreatePageViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    override fun getItemCount() =
        differ.currentList.size

    fun submitList(list: List<Person>) {
        differ.submitList(list)
    }

    fun updateList(list: List<Person>) {
        dataList.clear()
        dataList.addAll(list)
        notifyDataSetChanged()
    }


    inner class CreatePageViewHolder
    constructor(
        private val binding: RvItemBinding,
        private val listener: ItemOnClickListener?

    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Person) {
            with(binding) {
                tvMoney.text = data.price
                tvName.text = data.name
                tvSpec.text = data.specialist

//                imgItem.load(data.imgUrl)
                imgItem.setImageResource(data.imgUrl)

                root.setOnClickListener {
                    if (adapterPosition != RecyclerView.NO_POSITION)
                        listener?.onItemClickOption(adapterPosition, data)
                }
            }
        }
    }

    interface ItemOnClickListener {
        fun onItemClickOption(position: Int, data: Person)
    }
}

