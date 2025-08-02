@file:OptIn(ExperimentalMaterial3Api::class)

package com.illanes.myapplication01

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.DialogProperties

@Composable
fun AddContactDialog(
    state: ContactState,
    onEvent: (ContactEvent) -> Unit,
    modifier: Modifier = Modifier
) {

    BasicAlertDialog(
        onDismissRequest = {
            onEvent(ContactEvent.HideDialog)
        },
        modifier = modifier,
        properties = DialogProperties(),
        content = {
            Column(
                verticalArrangement = Arrangement.SpaceAround
            ) {
                TextField(
                    value = "Add contact",
                    onValueChange = {}
                )
                TextField(
                    value = state.firstName,
                    onValueChange = {
                        onEvent(ContactEvent.SetFirstName(it))
                    },
                    placeholder = {
                        Text(text = "First name")
                    }
                )
                TextField(
                    value = state.lastName,
                    onValueChange = {
                        onEvent(ContactEvent.SetLastName(lastName = it))
                    },
                    placeholder = {
                        Text(text = "Last name")
                    }
                )
                TextField(
                    value = state.phoneNumber,
                    onValueChange = {
                        onEvent(ContactEvent.SetPhoneNumber(phoneNumber = it))
                    },
                    placeholder = {
                        Text(text = "Phone number")
                    }
                )
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    Button(onClick = {
                        onEvent(ContactEvent.SaveContact)
                    }) {
                        Text(text = "Save")
                    }
                }
            }
        }
    )
}