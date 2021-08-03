package com.example.a4kwalpapers.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.a4kwalpapers.R
import com.example.a4kwalpapers.adapters.AdapterCategory
import com.example.a4kwalpapers.databinding.FragmentCategoriesBinding
import com.example.a4kwalpapers.models.category.Category
import com.example.a4kwalpapers.utils.MyList

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CategoriesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CategoriesFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    lateinit var fragmentCategoryBinding:FragmentCategoriesBinding
    lateinit var root:View
    lateinit var adapterCategory:AdapterCategory
    lateinit var listCategory:ArrayList<Category>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      fragmentCategoryBinding = FragmentCategoriesBinding.inflate(inflater,container,false)
        root = fragmentCategoryBinding.root
        loadCategory()
        adapterCategory = AdapterCategory(object:AdapterCategory.OnItemClicListener{
            override fun onImageClic(category: Category, position: Int) {
                var bundle = Bundle()
                bundle.putString("name",category.name)
                findNavController().navigate(R.id.categoryListImageFragment,bundle)
            }
        },listCategory)

        fragmentCategoryBinding.rvCategory.adapter = adapterCategory
        return root
    }


    private fun loadCategory() {
        listCategory = ArrayList()
        listCategory.add(Category("https://cdn.wallpapersafari.com/8/10/ketEf7.jpg","Editor's choice"))
        listCategory.add(Category("https://coolwallpapers.me/picsup/3070537-autumn_birds-eye-view_cars_countryside_forest_nature_road_trees_winding-road.jpg","Bird's eye view"))
        listCategory.add(Category("https://im0-tub-com.yandex.net/i?id=9e62c542cacea3cbdad2d8dc7d2aad40&n=13","Animals"))
        listCategory.add(Category("https://finnisharchitecture.fi/wordpress/wp-content/uploads/01-Wuxi-Grand-Theatre-Image-by-Jussi-Tiainen.jpg","Architecture"))
        listCategory.add(Category("https://img.wallpapersafari.com/desktop/1536/864/65/65/QixXWI.jpg","Avenue"))
        listCategory.add(Category("https://im0-tub-com.yandex.net/i?id=f4311e6863c3a1b07dbbea451255985c&n=13","Nature"))
        listCategory.add(Category("https://im0-tub-com.yandex.net/i?id=e7fdb8273c8cda4e7d8639ec2ef22bb0&n=13","Ocean"))
        listCategory.add(Category("https://im0-tub-com.yandex.net/i?id=c57a18bd5a9f1a192887b254f38c8f2e&n=13","Bokeh"))
        listCategory.add(Category("https://cdn.pixabay.com/photo/2015/09/05/21/26/night-925414_1280.jpg","Lights"))
        listCategory.add(Category("https://avatars.mds.yandex.net/get-zen_doc/1856150/pub_5f9710d44dcc5c613cd1db7d_5f984bf459810d5513047b37/scale_1200","Flowers"))
        listCategory.add(Category("https://im0-tub-com.yandex.net/i?id=7b64ddb0656fa42a05b5c271acef7300&n=13","Reflection"))
        listCategory.add(Category("https://i.pinimg.com/originals/41/83/2a/41832a50b03ae05f7b9a538e7f250ef8.jpg","Men"))
        listCategory.add(Category("https://im0-tub-com.yandex.net/i?id=49efd1972dfa93382ce58eca2937ea19&n=13","Women"))
        listCategory.add(Category("https://wallpaperforu.com/wp-content/uploads/2020/08/love-wallpaper-20081013453928-scaled.jpg","Love"))
        listCategory.add(Category("https://im0-tub-com.yandex.net/i?id=169d66ff3f0e3bfdbc17a49badc242a1&n=13","Silhouette"))
        listCategory.add(Category("https://im0-tub-com.yandex.net/i?id=f95ece8c17f630165391eb9b542877b4&n=13","Fireworks"))
        listCategory.add(Category("https://im0-tub-com.yandex.net/i?id=e177c36afe950697744534234db2bd12&n=13","Fire"))
        listCategory.add(Category("https://im0-tub-com.yandex.net/i?id=e16ef63760ac153ed6079fa8b25e3249&n=13","Galaxy"))
        listCategory.add(Category("https://im0-tub-com.yandex.net/i?id=392ae74d70693145b150804d5cac3984&n=13","Macro"))
        listCategory.add(Category("https://im0-tub-com.yandex.net/i?id=5ea152d486d42f647bd72884ff513318&n=13","Vehicles"))
        listCategory.add(Category("https://im0-tub-com.yandex.net/i?id=a2e8a85a2665b14a6484b1d6cb98ef90&n=13","Aircraft"))
        listCategory.add(Category("https://pixy.org/src/16/165298.jpg","Music"))
        listCategory.add(Category("https://im0-tub-com.yandex.net/i?id=d852a86ffcd9c7a424410bf6ebd04277&n=13","Food"))
        listCategory.add(Category("https://im0-tub-com.yandex.net/i?id=b79c2d0660893ecb3cdf92482800f820&n=13","Abstract"))
        listCategory.add(Category("https://im0-tub-com.yandex.net/i?id=54c1d02dd38e92933354daf457bdaf57&n=13","Texture"))
        listCategory.add(Category("https://picfiles.alphacoders.com/283/283689.jpg","Watercrafts"))
        listCategory.add(Category("https://girissetrabet.com/wp-content/uploads/2020/09/en-iyi-casino-siteleri.jpg","Football"))
        listCategory.add(Category("https://im0-tub-com.yandex.net/i?id=1857c53006719b44107ec5f12153cd13&n=13","Basketball"))
        listCategory.add(Category("https://im0-tub-com.yandex.net/i?id=3846d461b30354a3e2c5f01f73e0ca91&n=13","Tennis"))
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CategoriesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CategoriesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}