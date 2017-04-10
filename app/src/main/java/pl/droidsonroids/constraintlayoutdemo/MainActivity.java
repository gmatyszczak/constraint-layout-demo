package pl.droidsonroids.constraintlayoutdemo;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.transition.TransitionManager;
import android.support.v7.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.constraint_layout) ConstraintLayout mConstraintLayout;

    ConstraintSet mConstraintSetNormal = new ConstraintSet();
    ConstraintSet mConstraintSetView = new ConstraintSet();

    boolean mIsInViewMode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mConstraintSetNormal.clone(mConstraintLayout);
        mConstraintSetView.clone(this, R.layout.activity_main_view);
    }

    @OnClick(R.id.fab_view)
    public void onFabClick() {
        TransitionManager.beginDelayedTransition(mConstraintLayout);
        if (mIsInViewMode) {
            mConstraintSetNormal.applyTo(mConstraintLayout);
        } else {
            mConstraintSetView.applyTo(mConstraintLayout);
        }
        mIsInViewMode = !mIsInViewMode;
    }

}
