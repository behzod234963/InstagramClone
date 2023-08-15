package uz.datatalim.instagram.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import uz.datatalim.instagram.R
import uz.datatalim.instagram.model.FeedModel

class FeedAdapter(val context:Context,val list:ArrayList<FeedModel>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val ITEM_STORY=0
    val ITEM_POST=1

    override fun getItemViewType(position: Int): Int {

        return if (!list[position].stories.isNullOrEmpty()) ITEM_STORY else ITEM_POST

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val view:View

        if (viewType==ITEM_STORY){

            view=LayoutInflater.from(parent.context).inflate(R.layout.item_storiesmain,parent,false)
            return StoriesViewHolder(view)

        }else{

            view=LayoutInflater.from(parent.context).inflate(R.layout.item_pulication_forvideo,parent,false)
            return PostViewHolder(view)
        }

    }

    override fun getItemCount(): Int {

        return list.size

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val list=list[position]
        if (holder is PostViewHolder){

            holder.apply {



            }

        }
        if (holder is StoriesViewHolder){

            holder.apply {

                rvStories.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)

            }

        }

    }

    class PostViewHolder(view: View):RecyclerView.ViewHolder(view){

        val tvUsername:TextView=view.findViewById(R.id.tv_UserPost)

    }

    class StoriesViewHolder(view: View):RecyclerView.ViewHolder(view){

        val rvStories:RecyclerView=view.findViewById(R.id.rv_Story)

    }

}