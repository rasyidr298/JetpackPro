package id.rrdev.jetpackpro.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import id.rrdev.jetpackpro.data.Movie
import id.rrdev.jetpackpro.databinding.ItemRowMovieBinding
import id.rrdev.jetpackpro.utils.OnItemClicked
import id.rrdev.jetpackpro.utils.load

class MovieAdapter(
    private val onItemClicked: OnItemClicked
) : RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {

    var list = mutableListOf<Movie>()

    fun addList(listData : List<Movie>){
        val diffResult : DiffUtil.DiffResult = DiffUtil.calculateDiff(
            CarouselDiffCallback(
                list,
                listData
            )
        )
        list.clear()
        list.addAll(listData)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemRowMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(onItemClicked,binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(onItemClicked, list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class MyViewHolder(val onItemClicked: OnItemClicked, private val binding: ItemRowMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(onItemClicked: OnItemClicked, data: Movie) {
            with(binding){
                imgMovie.load(data.image)
                txtTitle.text = data.title
                txtDateOfRelease.text = data.dateOfRelease
                txtGenre.text = data.genre
            }
            binding.root.setOnClickListener {
                onItemClicked.onEventClick(data)
            }
        }

    }

    class CarouselDiffCallback(
        var oldList : List<Movie>,
        var newList : List<Movie>
    ) : DiffUtil.Callback(){
        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
//            return true
            return (oldList[oldItemPosition].id == newList[newItemPosition].id)
        }

        override fun getOldListSize(): Int {
            return oldList.size
        }

        override fun getNewListSize(): Int {
            return newList.size
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }
    }
}