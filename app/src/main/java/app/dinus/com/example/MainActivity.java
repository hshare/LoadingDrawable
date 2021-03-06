package app.dinus.com.example;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import razerdp.demo.DemoActivity;
import razerdp.demo.NewDemoActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnGoods;
    private Button mBtnAnimal;
    private Button mBtnScenery;
    private Button mBtnCircleJump;
    private Button mBtnShapeChange;
    private Button mBtnCircleRotate;
    private Button pop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pop = (Button) findViewById(R.id.pop);
        mBtnGoods = (Button) findViewById(R.id.goods);
        mBtnAnimal = (Button) findViewById(R.id.animal);
        mBtnScenery = (Button) findViewById(R.id.scenery);
        mBtnCircleJump = (Button) findViewById(R.id.circle_jump);
        mBtnShapeChange = (Button) findViewById(R.id.shape_change);
        mBtnCircleRotate = (Button) findViewById(R.id.circle_rotate);

        pop.setOnClickListener(this);
        mBtnGoods.setOnClickListener(this);
        mBtnAnimal.setOnClickListener(this);
        mBtnScenery.setOnClickListener(this);
        mBtnCircleJump.setOnClickListener(this);
        mBtnShapeChange.setOnClickListener(this);
        mBtnCircleRotate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.pop:
                Intent intent = new Intent(MainActivity.this, NewDemoActivity.class);
                startActivity(intent);
                break;
            case R.id.shape_change:
                ShapeChangeActivity.startActivity(this);
                break;
            case R.id.goods:
                GoodsActivity.startActivity(this);
                break;
            case R.id.animal:
                AnimalActivity.startActivity(this);
                break;
            case R.id.scenery:
                SceneryActivity.startActivity(this);
                break;
            case R.id.circle_jump:
                CircleJumpActivity.startActivity(this);
                break;
            case R.id.circle_rotate:
                CircleRotateActivity.startActivity(this);
                break;
            default:
                break;
        }
    }
}
