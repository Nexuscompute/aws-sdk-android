/*
 * Copyright 2010-2022 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.amazonaws.services.textract.model.transform;

import com.amazonaws.services.textract.model.*;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers.*;
import com.amazonaws.transform.*;
import com.amazonaws.util.json.AwsJsonReader;

/**
 * JSON unmarshaller for POJO LendingDocument
 */
class LendingDocumentJsonUnmarshaller implements
        Unmarshaller<LendingDocument, JsonUnmarshallerContext> {

    public LendingDocument unmarshall(JsonUnmarshallerContext context) throws Exception {
        AwsJsonReader reader = context.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        LendingDocument lendingDocument = new LendingDocument();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("LendingFields")) {
                lendingDocument.setLendingFields(new ListUnmarshaller<LendingField>(
                        LendingFieldJsonUnmarshaller.getInstance()
                        )
                                .unmarshall(context));
            } else if (name.equals("SignatureDetections")) {
                lendingDocument.setSignatureDetections(new ListUnmarshaller<SignatureDetection>(
                        SignatureDetectionJsonUnmarshaller.getInstance()
                        )
                                .unmarshall(context));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return lendingDocument;
    }

    private static LendingDocumentJsonUnmarshaller instance;

    public static LendingDocumentJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new LendingDocumentJsonUnmarshaller();
        return instance;
    }
}
