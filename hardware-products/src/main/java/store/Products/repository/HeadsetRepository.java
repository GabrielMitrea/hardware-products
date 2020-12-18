package store.Products.repository;

import org.springframework.stereotype.Repository;
import store.Products.model.ProductCategory;
import store.Products.model.products.Headset;
import store.Products.model.products.Mouse;
import store.Products.model.types.HeadsetType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Repository
public class HeadsetRepository {

    public static List<Headset> headsets = new ArrayList<>();

    public HeadsetRepository(){

        Headset h1=new Headset(214124124,ProductCategory.Headset, HeadsetType.Gaming,"n1","t1","s1","c1",21.13,null);
        Headset h2=new Headset(125452135,ProductCategory.Headset, HeadsetType.Business,"n2","t2","s2","c2",21.13,null);
        Headset h3=new Headset(165452352,ProductCategory.Headset, HeadsetType.Gaming,"n3","t3","s3","c3",21.13,null);
        Headset h4=new Headset(512534256,ProductCategory.Headset, HeadsetType.Business,"n4","t4","s4","c4",21.13,null);
        Headset h5=new Headset(215421551,ProductCategory.Headset, HeadsetType.Gaming,"n5","t5","s5","c5",21.13,null);
        headsets.add(h1);
        headsets.add(h2);
        headsets.add(h3);
        headsets.add(h4);
        headsets.add(h5);

    }

    public List<Headset> getHeadset(HeadsetType type, String sound){
        return headsets.stream()
                .filter(headset -> {
                    if(type==null && sound==null){
                        return true;
                    }
                    else
                    if (type != null) {
                        if (sound != null) {

                            return type.equals(headset.getType()) && sound.equals(headset.getSound());
                        } else {
                            return type.equals(headset.getType());
                        }
                    } else {
                        return sound.equals(headset.getSound());
                    }


                })
                .collect(Collectors.toList());
    }

    public Headset addNewHeadset(Headset headset){
        headset.setId(Math.abs(new Random().nextInt()));
        headsets.add(headset);
        return headset;
    }

    public Optional<Headset> getHeadsetById(long id){
        return headsets.stream()
                .filter(headset -> headset.getId()==id)
                .findFirst();
    }


}
