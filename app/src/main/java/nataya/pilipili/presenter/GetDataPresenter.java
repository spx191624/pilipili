package nataya.pilipili.presenter;

import nataya.pilipili.model.GetDataListener;
import nataya.pilipili.model.GetDataModel;
import nataya.pilipili.view.IgetDataView;

/**
 * Created by 191624 on 2017/4/6.
 */

public class GetDataPresenter {
    private GetDataModel getDataModel;
    private IgetDataView view;
    public GetDataPresenter(IgetDataView view){
        this.view =view;
        getDataModel = new GetDataModel();
    }
    public void getdata(String url){
        getDataModel.getData(url,new DataListenerImp());
    }



    public class DataListenerImp implements GetDataListener{

        @Override
        public void data(String data) {
            view.show(data);
        }
    }

}
