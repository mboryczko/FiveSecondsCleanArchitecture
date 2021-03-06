package pl.michal_boryczko.fiveseconds.ui.menu.impl

import android.os.Bundle
import butterknife.OnClick
import kotlinx.android.synthetic.main.activity_menu.*
import pl.michal_boryczko.fiveseconds.R
import pl.michal_boryczko.fiveseconds.base.BaseActivity
import pl.michal_boryczko.fiveseconds.ui.menu.MenuPresenter
import pl.michal_boryczko.fiveseconds.ui.menu.MenuView
import javax.inject.Inject

class MenuActivity : BaseActivity(), MenuView {

	@Inject
	lateinit var presenter: MenuPresenter

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_menu)
		activityComponent.inject(this)
		presenter.attachView(this)
	}


	@OnClick(R.id.buttonPlay)
	fun buttonPlayClicked(){

	}

	@OnClick(R.id.buttonMyQuestions)
	fun buttonMyQuestionsClicked(){

	}

	@OnClick(R.id.buttonPanel)
	fun buttonRulesClicked(){

	}

}
