/**
 * Generated by Gas3 v2.3.2 (Granite Data Services).
 *
 * NOTE: this file is only generated if it does not exist. You may safely put
 * your custom code here.
 */

package com.wineshop.admin.client.entities {
	
	import org.granite.persistence.PersistentSet;

    [Bindable]
    [RemoteClass(alias="com.wineshop.admin.entities.Vineyard")]
    public class Vineyard extends VineyardBase {

        public function Vineyard() {
            super();
			address = new Address();
			wines = new PersistentSet();
        } 
    }
}