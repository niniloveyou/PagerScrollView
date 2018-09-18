package com.deadline.pagerScrollView

import android.graphics.Color
import android.os.Bundle
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.dealine.pagerScrollView.FoolishScrollView
import com.dealine.pagerScrollView.VerticalViewPager
import info.hoang8f.android.segmented.SegmentedGroup

class ScrollLinkViewPagerActivity : AppCompatActivity() {

    private lateinit var segmentedGroup: SegmentedGroup
    private lateinit var toolbarLayout: LinearLayout
    private lateinit var rootLayout : LinearLayout
    private lateinit var viewPager: VerticalViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scroll_viewpager)

        toolbarLayout = findViewById(R.id.toolbarContainer)
        rootLayout = findViewById(R.id.root_layout)
        segmentedGroup = findViewById(R.id.segment)
        viewPager = findViewById(R.id.viewpager)

        createRadioButton(this, segmentedGroup, 0, "section one")
        createRadioButton(this, segmentedGroup, 1, "section two")
        createRadioButton(this, segmentedGroup, 2, "section three")

        segmentedGroup.weightSum = 3f
        segmentedGroup.updateBackground()
        segmentedGroup.check(0)

        viewPager.setOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(p0: Int) {

            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {

            }

            override fun onPageSelected(p0: Int) {
                segmentedGroup.updateBackground()
                segmentedGroup.check(p0)
            }

        })

        viewPager.adapter = BasePagerAdapter(arrayListOf(
                getScrollView("one", Color.BLACK),
                getScrollView("two", Color.parseColor("#0076ff")),
                getScrollView("three", Color.RED)))
        segmentedGroup.setOnCheckedChangeListener { _, checkedId ->
            viewPager.setCurrentItem(checkedId, true)
        }

    }


    private fun getScrollView(title: String, bgColor: Int): View {

        val view = LayoutInflater.from(this).inflate(R.layout.item_viewpager, null, false)
        val textView = view.findViewById<TextView>(R.id.text)
        textView.setBackgroundColor(bgColor)
        textView.text = "陈群出身汉末至魏晋时期的望族“颍川陈氏”。其祖父陈寔，父亲陈纪，叔父陈谌，于当世皆负盛名。" +
                "当陈群尚是幼儿时，祖父陈寔常认为此子奇异，向乡宗父老说：“这孩子必定兴旺吾宗。”鲁国人孔" +
                "融向来有高才而性格倨傲，他的年纪约在陈纪、陈群两父子之间，因此先与陈纪为友，后又与陈群结交，由是显名。 [3] \n" +
                "陈群曾经与孔融谈论汝、颍之间人物的优劣，陈群就说道：“荀文若、荀公达、荀休若、荀友若、" +
                "荀仲豫，当今无双。”可见二人常论骘人物，甚相交心。 [4] \n" +
                "兴平元年（194年），刘备时为豫州刺史，以陈群为别驾。其时陶谦病死，徐州以举州迎刘备继领，" +
                "刘备正欲前往，陈群便跟刘备说：“下袁术的力量还很强大，如果现在就东取徐州，一定会与袁术发" +
                "生争斗。要是吕布乘机袭击我军的后方，那时即使将军得了徐州，事情也一定不会有圆满的结局。" +
                "”刘备不听，还是东去徐州，与袁术争战。结果吕布果然兵袭下邳，又遣兵往助袁术，最终大破刘" +
                "备军，刘备这时候才悔恨当初没听陈群的劝告。\n" +
                "陈群后被举为茂才，除任柘令，不到任，于是随父亲陈纪往徐州避难。 [5] \n" +
                "知人之明\n" +
                "建安三年（198年），吕布为曹操所破，陈群父子亦在吕布军中，见曹操皆出拜 [6]  。曹操久闻其名，" +
                "便征陈群为司空西曹掾属。当时有人向曹操引荐乐安人王模、下邳人周逵，曹操均召而用之。陈群向曹操" +
                "力言不可，并以为王模、周逵二人德秽行劣，最终必然坏事，曹操不听。结果王周二人果然犯事受诛，曹" +
                "操方信陈群之言，并向陈群承认错失。陈群便推荐广陵人陈矫、丹阳人戴干，曹操皆加以任用。后来东吴" +
                "为叛，戴干因忠义死于变难；陈矫则成为一位名臣，是以举世均认同陈群知人之明。而自从刘备叛后，东" +
                "南多变，曹操便以陈群为酇令，以何夔为城父令，用名士以镇抚诸县，使官吏百姓安定。 [7]  又任萧（" +
                "今安徽萧县）、赞（今河南永城）、长平（今河南西华）县令。\n" +
                "建安四年（199年），陈纪去世，陈群因此辞官。后任司徒掾，举高第，为治书侍御史，转参丞相军事。 [8] \n" +
                "制定法度\n" +
                "《三国杀》中的陈群\n" +
                "《三国杀》中的陈群\n" +
                "建安十八年（213年），魏国建立后，陈群又迁为御史中丞。其时曹操正商议该否复使肉刑，于是下令说：“" +
                "怎样才有达于古今而通于变理的君子，可以助我决议此事呢！昔日陈鸿胪（指陈群父陈纪）以为死刑有可加" +
                "于仁恩的用途，正是在说这方面的事。御史中丞（指陈群）可以申述卿父之论吗？”\n" +
                "陈群说道：“臣下的父亲认为汉朝废除肉刑而增加鞭打、杖击，本意是出于仁恻之心，想减轻对犯人刑罚，" +
                "但没有想到死去的人却越来越多。正所谓名义上减轻而实际上加重了。因为名义上减轻了刑罚，老百姓容易忽" +
                "略而犯罪，这样实质上却加重了刑罚，老百姓也更容易受到伤害。《尚书》说：‘只有敬畏、慎用五刑，才能" +
                "养成三种德。’《周易》上也记载着割鼻、断足、砍脚趾的刑法，这些都是用来辅助政教、惩治邪恶的。况且" +
                "杀人偿命，也合乎古代的制度；对于把人打伤或毁坏别人的身体的罪犯，只是剃去头发圈住脖颈干活服役，就" +
                "不合道理了。如果沿用古刑，使奸淫者受宫刑，然后再把犯人关入蚕室，使偷盗者受刖刑，那么就永远不会发生" +
                "淫乱盗窃一类的坏事了。据说古代适用五刑的犯罪行为有三千多种，虽然不能全部恢复，但是像奸淫者下蚕室、" +
                "偷盗者刖其足这样的刑罚，由于奸淫、偷盗正是时下常有的祸患，因此应该首先施行。按照汉朝法律，对于" +
                "罪大恶极的犯人应当斩首，这是不能顾及所谓仁义的。但是对于其他刚够死刑、可杀可不杀的犯人，就可以施以肉刑。" +
                "这样，所受之刑与所犯之罪就可以相抵了。如今以鞭打、杖击处死的刑法代替肉刑，实在是只重视人的肢体而轻视人" +
                "的性命啊！”钟繇亦对陈群所议表示同意，而王朗及其它人则多以为未可复肉刑。曹操对钟、陈二人的看法深为赞同，" +
                "只是因为战事连绵，又顾及众人的议论，故暂且将此事搁置一旁。 [9] \n" +
                "后陈群转为侍中，领丞相东西曹掾。陈群的为人，在朝中对人无适无莫（语出《论语 里仁》：“君子之于天下也，" +
                "无适也，无莫也，义之与比。”意指对于人事没有厚薄之分），贵雅而执名杖义，不会为媚人而违背道德。"
        return view
    }
}

class BasePagerAdapter : PagerAdapter {

    private var views: List<View>? = null
    private var mTitles: List<CharSequence>? = null

    constructor(views: List<View>?) {
        this.views = views
    }

    constructor(views: List<View>?, titles: List<CharSequence>? = null) {
        this.views = views
        this.mTitles = titles
    }

    override fun getCount(): Int {
        return  views?.size ?: 0
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {

        return view === `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(views!![position])
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        container.addView(views!![position])
        return views!![position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return if (mTitles != null && mTitles!!.size > position) {
            mTitles!![position]
        } else ""

    }
}


