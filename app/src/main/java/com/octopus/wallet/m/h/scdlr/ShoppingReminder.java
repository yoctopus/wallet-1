/*
 * Copyright 2017, Peter Vincent
 * Licensed under the Apache License, Version 2.0, Vin Budget.
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.octopus.wallet.m.h.scdlr;

import android.content.Context;

import com.octopus.wallet.m.h.ntnt.INTENT_ACTION;
import com.octopus.wallet.m.h.ntnt.INTENT_MESSAGE;
import com.octopus.wallet.m.pb.ShoppingList;
import com.octopus.wallet.r.BReceiver;

import java.util.Calendar;

import me.yoctopus.cac.util.Scheduler;


public class ShoppingReminder extends Scheduler {
    private ShoppingList list;

    public ShoppingReminder(Context context,
                            ShoppingList list) {
        super(context, BReceiver.class);
        this.list = list;

    }

    @Override
    public Params onGetParam() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(list.getShoppingDate());
        Params one = new Params(INTENT_ACTION.SHOPPING_ACTION,
                INTENT_MESSAGE.SHOPPING_MESSAGE +
                        " '" +
                        list.getName() +
                        "' is due",
                calendar);
        one.setRepeating(false);

        return one;
    }

}
